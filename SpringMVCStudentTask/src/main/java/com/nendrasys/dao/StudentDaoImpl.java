package com.nendrasys.dao;

import com.nendrasys.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /* public StudentDaoImpl(JdbcTemplate template) {
         this.template = template;
     }*/
    @Override
    public List<Student> getAllStudent() {
        List<Student> list = template.query("SELECT * FROM students", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                return student;
            }
        });
        return list;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = (Student) template.queryForObject("SELECT * FROM students where id=?", new BeanPropertyRowMapper(Student.class), id);
        System.out.println(student.getAge() + ":" + student.getId());
        return student;
    }
}/*
        String QUERY = "SELECT * FROM STUDENTS WHERE id=?";
        Student student = template.query(QUERY, new ResultSetExtractor<Student>() {
            @Override
            public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Student student1 = new Student();
                student1.setId(resultSet.getInt("id"));
                student1.setName(resultSet.getString("name"));
                student1.setAge(resultSet.getInt("age"));
                return student1;
            }
        }, id);

        return student;
    }*/

    /*@Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(101);
        s1.setName("Shreesa");
        s1.setAge(23);
        studentList.add(s1);

        Student s2 = new Student();
        s2.setId(102);
        s2.setName("Ashwini");
        s2.setAge(22);
        studentList.add(s2);

        Student s3 = new Student();
        s3.setId(103);
        s3.setName("Venky");
        s3.setAge(24);
        studentList.add(s3);

        Student s4 = new Student();
        s4.setId(104);
        s4.setName("Mama");
        s4.setAge(23);
        studentList.add(s4);

        Student s5 = new Student();
        s5.setId(105);
        s5.setName("Ashu");
        s5.setAge(24);
        studentList.add(s5);

        return studentList;*/
