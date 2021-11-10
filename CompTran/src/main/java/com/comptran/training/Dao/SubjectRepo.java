package com.comptran.training.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comptran.training.Entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
