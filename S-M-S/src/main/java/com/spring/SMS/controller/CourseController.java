package com.spring.SMS.controller;

import com.spring.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/showCourse")
    public String showCourse(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "show_course";
    }
}
