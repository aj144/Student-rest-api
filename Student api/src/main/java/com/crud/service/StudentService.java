package com.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Student;
import com.crud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public Integer saveStudent(Student student) {
		Student st = studentRepo.save(student);
		return st.getId();
	}
	
	public List<Student> getAllStudents(){
		List<Student> student = new ArrayList<Student>();
		studentRepo.findAll().forEach(student1 -> student.add(student1));
		return student;
	}

	public void deleteStudentById(Integer Id) {
		studentRepo.deleteById(Id);
	}
	
	public Student getOneStudent(Integer Id) {
		return studentRepo.findById(Id).get();
	}
	
	public Integer updateStudent(Student student) {
		Student st = studentRepo.save(student);
		Integer Id = st.getId();
		return Id;
	}
}
