package com.rohit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.Helper.Message;
import com.rohit.entity.Student;
import com.rohit.services.StudentServices;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@PostMapping("/")
	public ResponseEntity<Message> createStudent(Student student) {
		boolean createStudent = studentServices.createStudent(student);
		if (createStudent) {
			System.out.println(createStudent);
			return ResponseEntity.status(HttpStatus.OK).body(new Message("Registered Successfully", "success"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new Message("Registration Unsuccessful", "danger"));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
		boolean deleteStudent = studentServices.deleteStudent(id);
		if (deleteStudent) {
			return ResponseEntity.status(HttpStatus.OK).body(new Message(" Deleted Successfully", "success"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new Message(" Deletion Unsuccessful", "danger"));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, Student student) {
		boolean updateStudent = studentServices.updateStudent(id, student);
		if (updateStudent) {
			return ResponseEntity.status(HttpStatus.OK).body(new Message("Updated Successfully", "success"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new Message("Updation Unsuccessful", "danger"));
		}
	}

	@GetMapping("/")
	public List<Student> getAllStudent() {
		return studentServices.getAllStudent();
	}

}
