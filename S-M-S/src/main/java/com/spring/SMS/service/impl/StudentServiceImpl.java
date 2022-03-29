package com.spring.SMS.service.impl;

import com.spring.SMS.model.Student;
import com.spring.SMS.repository.StudentRepository;
import com.spring.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        }else {
            throw new RuntimeException("Student not Found for ID: " +id);
        }
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }
}
