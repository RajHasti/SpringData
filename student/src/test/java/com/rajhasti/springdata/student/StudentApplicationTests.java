package com.rajhasti.springdata.student;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.student.entity.Student;
import com.rajhasti.springdata.student.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	public void testStudentCreate() {

		repository.save(new Student("Raj", "Hasti", 70));
		repository.save(new Student("Vikram", "Aditya", 90));
		repository.save(new Student("Rajini", "Konduru", 90));
		System.out.println("Student created successfully");

	}

	@Test
	public void testFindAllStudents() {

		System.out.println(repository.findAllStudents());
	}

	@Test
	public void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {

		System.out.println(repository.findAllStudentsByFirstName("Raj"));
	}

	@Test
	public void testFindAllStudentsForGivenScores() {

		System.out.println(repository.findAllStudentsForGivenScores(80, 100));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deleteStudByFirstName() {
		repository.deleteStudByFirstName("Raj");
	}
}
