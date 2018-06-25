package com.rajhasti.springdata.student.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rajhasti.springdata.student.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

  @Query("from Student")
  List<Student> findAllStudents();
  
  @Query("select st.firstName,st.lastName from Student st")
  List<Object[]> findAllStudentsPartialData();
  
  @Query("from Student where firstName=:firstName")
  List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
  
  @Query("from Student where score>:minScore and score<:maxScore")
  List<Student> findAllStudentsForGivenScores(@Param("minScore") int minScore,@Param("maxScore")int maxScore);
  
  @Modifying
  @Query("delete from Student where firstName=:firstName")
  void deleteStudByFirstName(@Param("firstName") String firstName);
  
}

