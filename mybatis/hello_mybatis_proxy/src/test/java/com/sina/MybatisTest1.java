package com.sina;

import com.sina.dao.StudentDao;
import com.sina.domain.Student;
import com.sina.util.MybatisUtils;
import com.sina.vo.QueryParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author radio
 * @create 2021-02-22 10:31 AM
 *
 * //使用动态代理来获取sql
 */
public class MybatisTest1 {
    @Test
    public void selectTest(){
        SqlSession session = MybatisUtils.getSqlsession();
        //获得会话对象；
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectStudents();
        for(Student stu:studentList){
            System.out.println(stu);
        }


    }
    @Test
    public void selectTestById(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        StudentDao dao = sqlsession.getMapper(StudentDao.class);
        List<Student> stu = dao.selectMultiParam("a0004",31);
        for (Student student:stu){
            System.out.println(student);
        }
    }
    @Test
    public void selectMultiObject(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        StudentDao dao = sqlsession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setAge(61);
        param.setSid("a0005");
        List<Student> students = dao.selectMultiObject(param);
        for (Student stu:students){
            System.out.println(stu);
        }

    }

}
