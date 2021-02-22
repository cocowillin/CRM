package com.sina;

import com.sina.domain.Student;
import com.sina.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author radio
 * @create 2021-02-22 10:31 AM
 */
public class MybatisTest1 {
    @Test
    public void insertTest(){

        SqlSession session = MybatisUtils.getSqlsession();

        Student stu1 = new Student();
        stu1.setSid("a0006");
        stu1.setSname("秦始皇");
        stu1.setAge(61);
        int addnum=session.insert("test1.insert",stu1);
        session.commit();
        session.close();
        System.out.println(addnum);


    }
}
