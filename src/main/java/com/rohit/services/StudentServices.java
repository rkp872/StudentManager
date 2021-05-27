package com.rohit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.entity.Student;
import com.rohit.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public boolean createStudent(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteStudent(long id) {
		try {
			Student student = studentRepository.findById(id).get();
			studentRepository.delete(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStudent(long id, Student newStudent) {
		try {
			Student oldStudent = studentRepository.findById(id).get();
			newStudent.setId(id);
			studentRepository.delete(oldStudent);
			studentRepository.save(newStudent);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
