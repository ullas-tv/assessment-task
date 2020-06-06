package com.uspartan.assessmenttask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uspartan.assessmenttask.entity.Student;
import com.uspartan.assessmenttask.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(this.studentService.createStudent(student));
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(this.studentService.updateStudent(student));
	}

	@DeleteMapping("/students/{id}")
	public HttpStatus deleteStudent(@PathVariable long id){
		this.studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
}