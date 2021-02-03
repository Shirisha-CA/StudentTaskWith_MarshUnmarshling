package com.nendrasys.service;

import com.nendrasys.dao.StudentDaoImpl;
import com.nendrasys.model.Student;
import com.nendrasys.model.StudentList;

import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    public StudentDaoImpl studentDao;
    public CustomOXMservices oxMservices;

    public CustomOXMservices getOxMservices() {
        return oxMservices;
    }

    public void setOxMservices(CustomOXMservices oxMservices) {
        this.oxMservices = oxMservices;
    }
    public StudentDaoImpl getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> fetchAllStudents(){
       return studentDao.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public String getStudentXmlById(int id) throws IOException {
        Student student = studentDao.getStudentById(id);
            return oxMservices.convertObjToXml(student);
    }

    @Override
    public Student getStudentObjById(String  xml) throws IOException {
        return oxMservices.convertXmlToObj(xml);
    }

    @Override
    public String getAllStudentDetailsInXml() throws IOException {
        StudentList studentList = new StudentList();
        studentList.setStudentList(studentDao.getAllStudent());
        return oxMservices.convertListObjToXml(studentList);
    }

    @Override
    public StudentList getStudentListObj(String xml) throws IOException {
        return (StudentList) oxMservices.convertListXmlToObj(xml);
    }
}
