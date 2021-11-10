package com.comptran.training.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comptran.training.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	Optional<Student> findByStudentIdAndPassword(int student_id, String password);

}
