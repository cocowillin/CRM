package com.sina.dao;

import com.sina.domain.Student;
import com.sina.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author radio
 * @create 2021-02-21 11:56 PM
 * 操作student 表格
 */
public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudents(Student stu);//添加了几行，也就是几个对象 就返回几个int；
    public int updateStudents(String sid,String sname,Integer age);
    public Student selectStudent(String sid);//查询单个学生根据id；
    //多个参数的查询
    public List<Student> selectMultiParam( String sid, Integer age);
    //通过对象来传参数 来完成查询；
    public List<Student> selectMultiObject(QueryParam param);
}
