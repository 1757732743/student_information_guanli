package com.ischoolbar.programmer.service.impl;

import com.ischoolbar.programmer.dao.ClazzDao_new;
import com.ischoolbar.programmer.dao.StudentDao_new;
import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Student_new;
import com.ischoolbar.programmer.service.StudentService_new;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl_new implements StudentService_new {
    @Autowired
    StudentDao_new studentDao;
    @Autowired
    ClazzDao_new clazzDao;
    @Override
    public List<Student_new> findStudentsByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<Student_new> students = studentDao.selectStudentsByLimit(begin, size);
        
        return students;
    }

    @Override
    public int getStudentsCount() {
        return studentDao.getStudentsCount();
    }

    @Override
    public int deleteStudents(List<Student_new> students) {
        return studentDao.deleteStudents(students);
    }

    @Override
    public int addStudent(Student_new student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student_new student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student_new> searchStudents(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //�������Ļ��������2������,���������������Ҫ����Ĳ���
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Student_new> students = studentDao.searchStudentsByLimit(map);
        return students;
    }

    @Override
    public List<Student_new> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //�������Ļ��������2������
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Student_new> students = studentDao.searchStudentsByLimitByTeacher(map);
        return students;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return studentDao.getSearchCount(searchParam);
    }

    @Override
    public int getSearchCountByTeacher(Map<String, Object> searchParam) {
        return studentDao.getSearchCountByTeacher(searchParam);
    }

    @Override
    public int getStudentsCountByTeacher(int tid) {
        return studentDao.getStudentsCountByTeacher(tid);
    }

    @Override
    public List<Student_new> findStudentsByPageByTeacher(Integer page, Integer size, int tid) {
        int begin = (page - 1) * size;
        List<Student_new> students = studentDao.selectStudentsByLimitByTeacher(begin, size, tid);
        return students;
    }

    @Override
    public List<Student_new> findStudentsByOid(int oid) {
        List<Student_new> students =  studentDao.selectStudentsByOid(oid);
        return students;
    }

    @Override
    //�����������������Ϣ��Ĳ���������sid��ֵ�ó���Ϣ������cid��ֵ�ҳ���Ӧ�İ༶��Ϣ����������ֱ���õ��༶��Ϣ
    public Student_new findStudentBySid(Integer sid) {
        Student_new student = studentDao.selectStudent(sid);
        return student;
    }

    @Override
    public String print(HttpServletRequest req){
        // ��ȡȫ��ѧ����Ϣ
        List<Student_new> students = studentDao.selectStudents();

        FileWriter fw = null;
        String fileName = null;
        try {
            // ��ȡ��ַ
            String path = req.getSession().getServletContext().getRealPath("report");
            File pathFile = new File(path);
            if (!pathFile.exists()) {
                boolean flag = pathFile.mkdirs();
                if (!flag) throw new RuntimeException("�����ļ���ʧ��");
            }
            // �ļ���ַ���ļ����ǵ�ǰʱ���
            long curTime = System.currentTimeMillis();
            fileName = curTime + ".csv";
            String filePath = path + "/" + fileName;
            // �����ļ�
            File file = new File(filePath);
            if (!file.exists()) {
                boolean flag = file.createNewFile();
                if (!flag) throw new RuntimeException("�����ļ�ʧ��");
            }
            // д�ļ�
            fw = new FileWriter(file, true);
            fw.write("���,����,ѧ��,�Ա�,����,�༶,״̬,��ע,���֤��,�绰,��ַ,��Уʱ��,����,��Ƭ\n");
            // ����ѧ����Ϣ
            for (Student_new student : students) {
                fw.write(student.getSid() + ",");
                fw.write(student.getSname() + ",");
                fw.write(student.getSnum() + ",");
                fw.write(student.getSsex() + ",");
                fw.write(student.getSage() + ",");
                fw.write(student.getCname() + ",");
                fw.write(student.getSstatus() + ",");
                fw.write(student.getSremark() + ",");
                fw.write(student.getIdcard() + ",");
                fw.write(student.getPhone() + ",");
                fw.write(student.getAddress() + ",");
                fw.write(student.getEntime() + ",");
                fw.write(student.getPswd() + ",");
                fw.write(student.getPic() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "report/" + fileName;
    }
}
