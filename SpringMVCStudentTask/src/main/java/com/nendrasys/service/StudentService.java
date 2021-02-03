package com.nendrasys.service;

import com.nendrasys.model.Student;
import com.nendrasys.model.StudentList;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<Student> fetchAllStudents();
    Student getStudentById(int id);
    String getStudentXmlById(int id) throws IOException;
    Student getStudentObjById(String xml) throws IOException;
    String getAllStudentDetailsInXml() throws IOException;
    StudentList getStudentListObj(String xml) throws IOException;
}
