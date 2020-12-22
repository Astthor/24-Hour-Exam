package com.programming.exam.controller;


import com.programming.exam.model.Student;
import com.programming.exam.model.Supervisor;
import com.programming.exam.service.StudentService;
import com.programming.exam.service.SupervisorService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @Autowired
    StudentService studentService;

    @Autowired
    SupervisorService supervisorService;




    @GetMapping("/students")
    public String getHomePage(Model model){
        // List of all students and supervisors:
        model.addAttribute("studentList", studentService.getAllStudents());
        model.addAttribute("supervisorList", supervisorService.getAllSupervisors());

        // New instance of Student object, for "Register Student" From.
        Student student = new Student();
        model.addAttribute("newStudent", student);

        return "exam";
    }


    @PostMapping("/student-update")
    public String updateStudent (@ModelAttribute Student student){
        // Service finds an instance of an Optional<Student> object in the repo, returns the found student or null.
        /*Supervisor supervisor = supervisorService.getSupervisorById(student.getSupervisorBySupervisorId().getId());

        // Saves student with relevant supervisor if found in the database.
        if(supervisor != null) {
            student.setSupervisorBySupervisorId(supervisor);
            studentService.saveStudent(student);
        }

         */
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/student-create")
    public String createStudent (@ModelAttribute Student newStudent){
        studentService.saveStudent(newStudent);
        return "redirect:/students";
    }

    @PostMapping("/student-delete/{id}")
    public String deleteStudent (@PathVariable("id") long id){
        Student student = studentService.findStudentById(id);
        if(student != null){
            studentService.deleteStudent(student);
        }
        return "redirect:/students";
    }




}
