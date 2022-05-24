package com.ischoolbar.programmer.controller;

import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Teacher;
import com.ischoolbar.programmer.service.ClazzService_new;
import com.ischoolbar.programmer.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clazz_new")
public class ClazzController_new {

    @Autowired
    ClazzService_new service;

    /**
     * ��ѯ�༶
     * @param page ��ǰҳ��
     * @param limit ÿҳ��С
     * @return �༶��Ϣ
     */
    @RequestMapping("queryClazzs.do")
    public Map<String,Object> queryClazzs(Integer page, Integer limit){
        //��ȡ����
        int count = service.getAmount();
        //��ȡ����
        List<Clazz_new> clazzs = service.queryClazzs(page, limit);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", clazzs);
        return res;
    }

    /**
     * ��ѯ���а༶
     * @return �༶��Ϣ
     */
    @RequestMapping({"queryAllClazzs.do", "student/queryAllClazzs.do"})
    public List<Clazz> queryAllClazzs(){
        List<Clazz> clazzes = service.queryAllClazzs();
        return clazzes;
    }



    /**
     * ɾ���༶
     * @param json �༶�����json
     * @return �ɹ�����
     */
    @RequestMapping("deleteClazzs.do")
    public Integer deleteClazzs(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //�������������ʽ�����������ʽ
        List<Clazz_new> clazzs = JsonUtil.parseList(json, Clazz_new.class);
        int count = service.deleteClazzs(clazzs);   //�õ�ɾ���ɹ�������
        return count;
    }

    /**
     * ���һ���༶
     * @param json �༶�����json
     * @return �ɹ���־1
     */
    @RequestMapping("addClazz.do")
    public Integer addClazz(String json){
        Clazz_new clazz = JsonUtil.parseObject(json, Clazz_new.class);
        int num = service.addClazz(clazz);
        return num;
    }

    /**
     * �޸�һ���༶
     * @param json �༶�����json
     * @return �ɹ���־1
     */
    @RequestMapping("updateClazz.do")
    public Integer updateClazz(String json){
        Clazz_new clazz = JsonUtil.parseObject(json, Clazz_new.class);
        int num = service.updateClazz(clazz);
        return num;
    }

    /**
     * ��ȡ�༶����
     * @return �༶����
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        int res = service.getAmount();
        return res;
    }

    /**
     * �����༶
     * @param page ��ǰҳ��
     * @param limit ÿҳ��С
     * @param json ����������json
     *             {"cname": �༶��, "mid": רҵid}
     * @return �༶��Ϣ
     */
    @RequestMapping("searchClazzs.do")
    public Map<String,Object> searchClazzs(Integer page, Integer limit, String json){
        //��������Ĳ���
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //��ȡ��ѯ����
        int count = service.getSearchCount(searchParam);
        //��ѯ����
        List<Clazz_new> clazzes = service.searchClazzs(page, limit, searchParam);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", clazzes);
        return res;
    }
}
