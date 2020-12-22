package com.programming.exam.service;

import com.programming.exam.model.Supervisor;
import com.programming.exam.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    public List<Supervisor> getAllSupervisors(){
        return supervisorRepository.findAll();
    }

    public Supervisor getSupervisorById(long id){
        Optional<Supervisor> supervisor = supervisorRepository.findById(id);
        if(supervisor.isPresent()){
            return supervisor.get();
        }
        return null;
    }
}
