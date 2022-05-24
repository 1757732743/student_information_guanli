package com.ischoolbar.programmer.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/update")
public class UpdateController {

    /**
     * �ҵ��ϴ�
     * @param req HttpServletResponse
     * @param resp HttpServletResponse
     * @param dirName �ļ�����
     * @return
     */
    private Map<String,String> myUpdate(HttpServletRequest req, HttpServletResponse resp, String dirName) {
        String picPath = req.getSession().getServletContext().getRealPath(dirName);

        String resPath = null;
        String fileName = null;

        //���ж��ϴ��������Ƿ������ݣ�ֻ���Ƕ�ε����ݣ������ļ��ϴ��ģ�
        if (ServletFileUpload.isMultipartContent(req)) {
            // ���� FileItemFactory ����ʵ����
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // �������ڽ����ϴ����ݵĹ����� ServletFileUpload ��
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // �����ϴ������ݣ��õ�ÿһ������ FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // ѭ���жϣ�ÿһ���������ͨ���ͣ������ϴ����ļ�
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        // ��ͨ����
                        System.out.println("����� name ����ֵ��" + fileItem.getFieldName());
                        // ���� UTF-8.�����������
                        System.out.println("����� value ����ֵ��" + fileItem.getString("UTF-8"));
                    } else {
                        // �ϴ����ļ�
                        System.out.println("����� name ����ֵ��" + fileItem.getFieldName());
                        System.out.println("�ϴ����ļ�����" + fileItem.getName());
                        fileName = fileItem.getName();
                        // �Ӹ�ʱ�����ֹ����
                        String newFileName = System.currentTimeMillis() + fileName;
                        resPath =  dirName + "/" + newFileName;
                        fileItem.write(new File(picPath + "/" + newFileName));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String,String> resMap = new HashMap<>();
        resMap.put("resPath", resPath);
        resMap.put("fileName", fileName);

        return resMap;
    }

    /**
     * �ϴ�ͼƬ
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return ��Ҫ��
     */
    @RequestMapping("updateImg.do")
	public Map<String, String> uploadPhoto(MultipartFile photo,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException{
		Map<String, String> ret = new HashMap<String, String>();
		if(photo == null){
			//�ļ�û��ѡ��
			ret.put("type", "error");
			ret.put("msg", "��ѡ���ļ���");
			return ret;
		}
		if(photo.getSize() > 10485760){
			//�ļ�û��ѡ��
			ret.put("type", "error");
			ret.put("msg", "�ļ���С����10M�����ϴ�С��10M��ͼƬ��");
			return ret;
		}
		String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1,photo.getOriginalFilename().length());
		if(!"jpg,png,gif,jpeg".contains(suffix.toLowerCase())){
			ret.put("type", "error");
			ret.put("msg", "�ļ���ʽ����ȷ�����ϴ�jpg,png,gif,jpeg��ʽ��ͼƬ��");
			return ret;
		}
		String savePath = request.getServletContext().getRealPath("/") + "\\upload\\";
		System.out.println(savePath);
		File savePathFile = new File(savePath);
		if(!savePathFile.exists()){
			savePathFile.mkdir();//��������ڣ��򴴽�һ���ļ���upload
		}
		//���ļ�ת�浽����ļ�����
		String filename = new Date().getTime() + "." + suffix;
		photo.transferTo(new File(savePath + filename ));
		ret.put("type", "success");
		ret.put("msg", "ͼƬ�ϴ��ɹ���");
		ret.put("src", request.getServletContext().getContextPath() + "/upload/" + filename);
		return ret;
	}
    /**
    public Map<String,Object> updateImg(HttpServletRequest req, HttpServletResponse resp){
        String resPath = myUpdate(req, resp, "pictures").get("resPath");

        Map<String,Object> res = new HashMap<>();
        res.put("code",0);
        res.put("msg","");
        Map<String,String> tmp = new HashMap<>();
        tmp.put("src",resPath);
        res.put("data", tmp);

        return res; 
    } */

}
