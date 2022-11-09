package com.crud.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Student;
import com.crud.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String>saveStudentEntity(@RequestBody Student student) {
		Integer Id = studentService.saveStudent(student);
		String message = "Student Added, Id:" +Id;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<Student>>getAllStudents(){
		List<Student> student = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String>deleteStudent (@PathVariable("Id")Integer Id) {
		
		studentService.deleteStudentById(Id);
		String message = "Student Deleted , Id:"+Id;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("fetch/{Id}")
	public ResponseEntity<Student>getStudent(@PathVariable("Id")Integer Id){
		
		Student student =studentService.getOneStudent(Id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<String>updateStudent(@RequestBody Student student) {
		Integer Id = studentService.updateStudent(student);
		String message = "Student Updated Id :" +Id;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
