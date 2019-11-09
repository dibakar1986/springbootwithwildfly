package com.dcwebworks.springbootwithwildfly.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcwebworks.springbootwithwildfly.exception.StudentNotFoundException;
import com.dcwebworks.springbootwithwildfly.model.DefaultResponse;
import com.dcwebworks.springbootwithwildfly.model.Student;
import com.dcwebworks.springbootwithwildfly.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {
	private final StudentRepository studentRepository;
	
	public StudentController( StudentRepository repository) {
		this.studentRepository = repository;
	}
	
	@GetMapping
	public Iterable<Student> getAllStudents () {
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getStudent (@PathVariable Long id) {
		return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent (@PathVariable Long id, @RequestBody Student student) {
		Student studentDetails = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
		studentDetails.setFirstName(student.getFirstName());
		studentDetails.setLastName(student.getLastName());
		studentDetails.setYear(student.getYear());
		
		return studentRepository.save(studentDetails);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DefaultResponse> deleteStudent(@PathVariable Long id) {
		studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
		studentRepository.deleteById(id);
		DefaultResponse resp = new DefaultResponse();
		resp.setMessage("Successfully deleted");
		return new ResponseEntity<DefaultResponse>(resp, HttpStatus.OK);
	}
}
