package com.sudo.springdatajpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sudo.springdatajpa.model.Student;
import com.sudo.springdatajpa.repository.StudentRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	StudentRepository repo;
	
	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Sudeepa");
		student.setTestScore(100);
		
		repo.save(student);
		
		Optional<Student> st = repo.findById(1l);
		
		Assertions.assertEquals(student.getId(), st.get().getId());
		Assertions.assertEquals(student.getName(), st.get().getName());
		Assertions.assertEquals(student.getTestScore(), st.get().getTestScore());
		
	}
	

	@Test
	void testFindStudent() {
		Student student1 = new Student(1L,"Sudeepa",100);
		Student student2 = new Student(2L,"Prasanth",100);
		
		List<Student> listOfStudent = List.of(student1, student2);		
		repo.saveAll(listOfStudent);
		
		List<Student> list = repo.findAll();
		
		Assertions.assertEquals(listOfStudent.size(), list.size());
		
	}
	
	@Test
	void testUpdateStudent() {
		Student student1 = new Student(1L,"Pranish",100);
		Student student2 = new Student(2L,"Pranay",100);
		
		List<Student> listOfStudent = List.of(student1, student2);		
		repo.saveAll(listOfStudent);
		
		repo.save(new Student(1L,"Advika",100));
		Optional<Student> st = repo.findById(1l);
		
		Assertions.assertEquals("Advika",st.get().getName());
		
	}
	
	@Test
	void testDeleteStudent() {
		Student student1 = new Student(1L,"Vani",100);
		Student student2 = new Student(2L,"Pranay",100);
		Student student3 = new Student(3L,"Deeksha",100);
		
		
		List<Student> listOfStudent = List.of(student1, student2, student3);		
		repo.saveAll(listOfStudent);
		
		repo.delete(student3);
		Optional<Student> st = repo.findById(3l);
		List<Student> list = repo.findAll();
		
		Assertions.assertEquals(Optional.empty(), st);
		Assertions.assertEquals(2, list.size());
		
		
	}

}
