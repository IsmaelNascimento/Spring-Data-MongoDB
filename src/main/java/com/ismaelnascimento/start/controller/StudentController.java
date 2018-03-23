package com.ismaelnascimento.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ismaelnascimento.start.repository.StudentRepository;
import com.ismaelnascimento.start.entity.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value="/savestudent", method = RequestMethod.POST) // Create // Update
	public Student saveStudent(@RequestBody Student student){
		return this.studentRepository.save(student);
	}
	
	@RequestMapping(value="/students", method = RequestMethod.GET) // Read
	public List<Student> listStudents(){
		return this.studentRepository.findAll();
	}

	@RequestMapping(value="/student/{id}", method = RequestMethod.GET) // Read
	public Optional<Student> findId(@PathVariable String id){
		return this.studentRepository.findById(id);
	}
	
	@RequestMapping(value="/student/{name}/name", method = RequestMethod.GET) // Read
	public List<Student> findByNameLikeIgnoreCase(@PathVariable String name){
		return this.studentRepository.findByNameLikeIgnoreCase(name);
	}

	@RequestMapping(value="/student/{id}", method = RequestMethod.POST) // Delete
	public void deleteStudent(@PathVariable String id){
		this.studentRepository.deleteById(id);
	}
	
}
