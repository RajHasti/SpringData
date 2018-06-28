package com.rajhasti.springdata.student.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rajhasti.springdata.student.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);

	@Query("select st.firstName,st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();

	@Query("from Student where firstName=:firstName")
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

	@Query("from Student where score>:minScore and score<:maxScore")
	List<Student> findAllStudentsForGivenScores(@Param("minScore") int minScore, @Param("maxScore") int maxScore);

	@Modifying
	@Query("delete from Student where firstName=:firstName")
	void deleteStudByFirstName(@Param("firstName") String firstName);

	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentNQ();
	
	@Query(value="select * from student where fname=:firstName",nativeQuery=true)
	List<Student> findAllByFirstNameNQ(@Param("firstName") String firstName );
	
	@Query(value="select fname,lname from Student",nativeQuery=true)
	List<Object[]> findAllStudentsPartialDataNQ();
}
