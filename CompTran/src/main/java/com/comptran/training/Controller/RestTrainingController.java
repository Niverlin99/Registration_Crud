package com.comptran.training.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comptran.training.Dao.StaffRepo;
import com.comptran.training.Dao.StudentRepo;
import com.comptran.training.Dao.TeacherRepo;
import com.comptran.training.Entity.Staff;
import com.comptran.training.Entity.Student;
import com.comptran.training.Entity.Teacher;

@RestController
public class RestTrainingController {

	@Autowired
	StaffRepo staffRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
	@PostMapping("/saveStaff")
	public Staff setStaffDetails(@RequestBody Staff staff) {
		staffRepo.save(staff);
		return staff;
	}
	@PostMapping("/saveStudent")
	public Student setStudentDetails(@RequestBody Student student) {
		studentRepo.save(student);
		return student;
	}
	@GetMapping("/student")
	public List<Student>getStudent(){
		return studentRepo.findAll();
	}
	@GetMapping("/New")
	public String newx(){
		return "Hi Niverlin";
	}
	@GetMapping("/student/{student_id}")
	public Optional<Student>getStudentById(@PathVariable("student_id") int id){
		return studentRepo.findById(id);
	}
	@PostMapping("/staff/teacher")
	public Staff setStaffTeacherDetails(@RequestBody Staff staff) {
		Teacher teacher = staff.getTeacher();
		Teacher teacher_temp = new Teacher();
		teacher_temp=teacherRepo.save(teacher);
		staff.setTeacher(teacher_temp);
		staffRepo.save(staff);
		return staff;
	}
	@GetMapping("/staff/{staff_id}")
	public Optional<Staff>getStaffDetails(@PathVariable("staff_id") int id){
		return staffRepo.findById(id);
	}
	@GetMapping("/staff/teacher/subject/{teacher_id}")
	public Optional<Teacher>getTeacherSubjectDetails(@PathVariable("teacher_id") int id){
		return teacherRepo.findById(id);
	}
	@GetMapping("/staff/teacher/{teacher_id}")
	public Staff getStaffTeacherById(@PathVariable("teacher_id") int teacher_id) {
		return staffRepo.findByTeacher_TeacherId(teacher_id);
	}
}
