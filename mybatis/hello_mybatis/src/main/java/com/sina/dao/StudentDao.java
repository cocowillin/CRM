package com.sina.dao;

import com.sina.domain.Student;

import java.util.List;

/**
 * @author radio
 * @create 2021-02-21 11:56 PM
 * 操作student 表格
 */
public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student stu);//添加了几行，也就是几个对象 就返回几个int；
}
