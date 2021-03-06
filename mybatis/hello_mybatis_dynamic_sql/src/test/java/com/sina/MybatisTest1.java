package com.sina;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.sina.dao.StudentDao;
import com.sina.domain.Student;
import com.sina.util.MybatisUtils;
import com.sina.vo.QueryParam;
import com.sina.vo.StudentAllmsg;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Student stu = new Student();
        stu.setAge(40);
        stu.setSname(null);

        List<Student> studentList = dao.selectStudentIf(stu);
        for (Student stu1:studentList){
            System.out.println(stu1);
        }
        session.close();
    }
    @Test
    public void selectAll(){


            SqlSession sqlsession = MybatisUtils.getSqlsession();
            StudentDao dao = sqlsession.getMapper(StudentDao.class);
            PageHelper.startPage(1,2);
            List<Student> studentList = dao.selectAll();

            for (Student stu:studentList){
                System.out.println(stu);
            }
            sqlsession.close();
            System.out.println("这回看能不能回退啦  啦啦啦啦啦");



    }
    @Test
    public void selectMultiTable(){//多表查询
            SqlSession sqlsession = MybatisUtils.getSqlsession();
            StudentDao dao = sqlsession.getMapper(StudentDao.class);
            List< Map<String, Object>> stringObjectMap = dao.selectMultiTable();
            for (Map<String,Object> map:stringObjectMap){
                Set<String> set = map.keySet();
                for (String key:set){
                    System.out.println("key="+key);
                    System.out.println("value="+map.get(key));

                }
                System.out.println("_______________________");

            }

            sqlsession.close();


    }
    @Test
    public void selectAllmsg(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        StudentDao dao = sqlsession.getMapper(StudentDao.class);
        List<StudentAllmsg> studentAllmsgList=dao.selectStudentAllmsg("2");
        for (StudentAllmsg studentAllmsg:studentAllmsgList){
            System.out.println(studentAllmsg);
        }

    }


}
   /* @Test
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

    }*/


