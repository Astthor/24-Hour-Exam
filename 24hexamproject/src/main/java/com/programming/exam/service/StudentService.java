package com.programming.exam.service;

import com.programming.exam.model.Student;
import com.programming.exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents (){
        return studentRepository.findAll();
    }

    public Student findStudentById(long id){
        Optional<Student > studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            return student;
        }
        return null;
    }

    public Student saveStudent (Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent (Student student){
        studentRepository.delete(student);
    }

}
