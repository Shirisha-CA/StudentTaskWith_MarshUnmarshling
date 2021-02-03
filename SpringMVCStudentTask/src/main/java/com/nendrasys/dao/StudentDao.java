package com.nendrasys.dao;

import com.nendrasys.model.Student;

import java.util.List;

public interface StudentDao {
     List<Student> getAllStudent() ;
     Student getStudentById(int id);
}
