package com.uspartan.assessmenttask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uspartan.assessmenttask.entity.Student;
import com.uspartan.assessmenttask.exception.ResourceNotFoundException;
import com.uspartan.assessmenttask.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		Optional<Student> studentDb = this.studentRepository.findById(student.getId());

		if (studentDb.isPresent()) {
			Student studentUpdate = studentDb.get();
			studentUpdate.setId(student.getId());
			studentUpdate.setName(student.getName());
			studentUpdate.setAge(student.getAge());
			studentUpdate.setAddress(student.getAddress());
			studentRepository.save(studentUpdate);
			return studentUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + student.getId());
		}
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student getStudentById(long id) {

		Optional<Student> studentDb = this.studentRepository.findById(id);

		if (studentDb.isPresent()) {
			return studentDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

	public void deleteStudent(long id) {
		Optional<Student> studentDb = this.studentRepository.findById(id);

		if (studentDb.isPresent()) {
			this.studentRepository.delete(studentDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}

	}

}