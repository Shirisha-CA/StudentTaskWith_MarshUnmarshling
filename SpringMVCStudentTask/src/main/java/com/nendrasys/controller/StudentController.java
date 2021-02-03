package com.nendrasys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nendrasys.model.StudentList;
import com.nendrasys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nendrasys.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller("studentController")
@RequestMapping("/")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @RequestMapping("/student")
    public String showAllStudent(Map<String, Object> map) {
        List<Student> students = studentService.fetchAllStudents();
        map.put("listOfStudents", students);
        return "showStudent";
    }

    @RequestMapping("/studentId/{id}")
    public String getStudentById(Model model,@PathVariable(value = "id") int id){
        model.addAttribute("getStudentById",studentService.getStudentById(id));
        return "student";
    }
    @RequestMapping("/studentId")
    public String getStudentByIdR(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("getStudentById", studentService.getStudentById(id));
        return "student";
    }

    @ResponseBody
    @RequestMapping(value="/studentXml", produces = {"application/xml"})
    public String getStudentXmlById(@RequestParam(value = "id") int id) throws IOException {
        return studentService.getStudentXmlById(id);
    }

    @ResponseBody
    @RequestMapping(value="/studentObject")
    public Student getStudentObjectFromXml(@RequestParam(value = "id") int id) throws IOException {
        String xml = studentService.getStudentXmlById(id);
        Student student = studentService.getStudentObjById(xml);
        System.out.println("controller object::"+student);
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/getXml", produces = {"application/xml"})
    public String getAllDetailsInXml() throws IOException {
        return studentService.getAllStudentDetailsInXml();
    }

    @ResponseBody
    @RequestMapping(value = "/getObject")
    public StudentList getAllDetailsFromXmltoObj() throws IOException {
        String xml = studentService.getAllStudentDetailsInXml();
        StudentList students = (StudentList) studentService.getStudentListObj(xml);
        return students;
    }
}

