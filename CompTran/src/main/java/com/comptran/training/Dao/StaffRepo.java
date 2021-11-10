package com.comptran.training.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comptran.training.Entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

	Staff findByTeacher_TeacherId(Integer teacher_id);

	List<Staff> findByPasscode(String passcode);

}
