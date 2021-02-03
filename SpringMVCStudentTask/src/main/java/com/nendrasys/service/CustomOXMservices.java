package com.nendrasys.service;

import com.nendrasys.model.Student;
import com.nendrasys.model.StudentList;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class CustomOXMservices {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    public Marshaller getMarshaller() {
        return marshaller;
    }
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    //convert object to xml specified id
    public String convertObjToXml(Student student) throws IOException {
        StringWriter stringWriter = new StringWriter();
        getMarshaller().marshal(student, new StreamResult(stringWriter));
        System.out.println(stringWriter);
        return stringWriter.toString();
    }

    //convert xml to object specified id
    public Student convertXmlToObj(String xml) throws IOException {
        StringReader stringReader = new StringReader(xml);
        Student student1 = (Student) getUnmarshaller().unmarshal(new StreamSource(stringReader));
        System.out.println("Xml to object::"+student1);
        return student1;
    }

    //convert list object to xml
    public String convertListObjToXml(StudentList student) throws IOException {
        StringWriter stringWriter = new StringWriter();
        getMarshaller().marshal(student, new StreamResult(stringWriter));
        System.out.println("Object to Xml::"+stringWriter);
        return stringWriter.toString();
    }

    //convert list xml to object
    public StudentList convertListXmlToObj(String xml) throws IOException {
        StringReader stringReader = new StringReader(xml);
        StudentList studentList= (StudentList) getUnmarshaller().unmarshal(new StreamSource(stringReader));
        System.out.println("Xml to Object::"+studentList.getStudentList().toString());
        return studentList;
    }
}
