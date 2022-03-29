package com.spring.SMS.controller;

import com.spring.SMS.model.Student;
import com.spring.SMS.service.StudentService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allStudent")
    public String showStudents(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "show_students";
    }

    @GetMapping("/showAddStudentForm")
    public String showAddStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("addStudent", student);
        return "create_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("Student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/allStudent";
    }

    @GetMapping("/showUpdateStudentForm/{id}")
    public String showUpdateStudentForm(@PathVariable (value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("updateStudent", student);
        return "update_student";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("Student") Student student, Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setStudentId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setDOB(student.getDOB());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setPhoneNumber(student.getPhoneNumber());

        studentService.updateStudent(existingStudent);
        return "redirect:/allStudent";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") Long id) {
        this.studentService.deleteStudent(id);
        return "redirect:/allStudent";
    }

}
