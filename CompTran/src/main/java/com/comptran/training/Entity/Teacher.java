package com.comptran.training.Entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacher_technology;
	

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacher_technology() {
		return teacher_technology;
	}

	public void setTeacher_technology(String teacher_technology) {
		this.teacher_technology = teacher_technology;
	}
	
}
