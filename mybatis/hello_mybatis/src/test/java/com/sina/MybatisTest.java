package com.sina;

import com.sina.domain.Student;
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
public class MybatisTest {
    @Test
    public void insertTest(){
        String resourse="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();//可以带参 可以true可以自动提交事务；

        Student stu1 = new Student();
        stu1.setSid("a0004");
        stu1.setSname("武则天");
        stu1.setAge(32);
        int addnum=session.insert("test1.insert",stu1);
        session.commit();
        session.close();
        System.out.println(addnum);


    }
}
