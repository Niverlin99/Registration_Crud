package com.comptran.training.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comptran.training.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	Address findByStudent_StudentId(int studentId);

}
