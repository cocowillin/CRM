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
        List<Student> selectStudentIf(Student stu);
        List<Student> selectAll();

}
