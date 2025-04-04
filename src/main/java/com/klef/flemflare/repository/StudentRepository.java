package com.klef.flemflare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.flemflare.model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Integer>
{
	@Query("select s from Student s where s.email=?1 and s.password=?2")
	public Student checkstulogin(String stuemail, String stupwd);
	
	


}
