package com.comptran.training.Controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comptran.training.Dao.AddressRepo;
import com.comptran.training.Dao.StaffRepo;
import com.comptran.training.Dao.StudentRepo;
import com.comptran.training.Dao.SubjectRepo;
import com.comptran.training.Dao.TeacherRepo;
import com.comptran.training.Entity.Address;
import com.comptran.training.Entity.Staff;
import com.comptran.training.Entity.Student;
import com.comptran.training.Entity.Teacher;
import com.comptran.training.Model.DemoModel;

@Controller
public class TrainingController {


	@Autowired
	StaffRepo staffRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
	@Autowired
	SubjectRepo subjectRepo;
	@Autowired
	AddressRepo addressRepo;
	@Autowired
	DemoModel demoModel;
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}
	@RequestMapping("/loginOption")
	public ModelAndView getLoginOption() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login_option");
		return mv;
	}
	
	@RequestMapping("/student_signIn")
	public ModelAndView getStudentSignUp() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("student_signup");
		return mv;
	}
	@RequestMapping("/staff_signIn")
	public ModelAndView getStaffSignUp() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("staff_signup");
		return mv;
	}
	@RequestMapping("/student_login")
	public ModelAndView getStudentLogIn() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("student_login");
		return mv;
	}
	@RequestMapping("/staff_login")
	public ModelAndView getStaffLogIn() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("staff_login");
		return mv;
	}
	@RequestMapping("/teacher_login")
	public ModelAndView getTeacherLogIn() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("techer_login");
		return mv;
	}
	@RequestMapping("/teacher_signIn")
	public ModelAndView getTeacher_signup() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("teacher_signup");
		return mv;
	}
	@RequestMapping("/setStaffSignUpDetails")
	public ModelAndView setStaffSignUpDetails(Staff staff) {
		ModelAndView mv= new ModelAndView();
		staffRepo.save(staff);
		mv.setViewName("welcome");
		return mv;
	}
	@RequestMapping("/setTeacherSignUpDetails")
	public ModelAndView setTeacherSignUpDetails(Staff staff,Teacher teacher) {
		ModelAndView mv= new ModelAndView();
		Staff staff_temp = new Staff();
		Teacher teacher_temp = teacher;
		staff_temp.setTeacher(teacher);
		staff_temp.setEmp_name(staff.getEmp_name());
		staff_temp.setPasscode(staff.getPasscode());
		teacher_temp= teacherRepo.save(teacher);
		staff_temp.setTeacher(teacher_temp);
		staffRepo.save(staff_temp);
		mv.setViewName("welcome");
		return mv;
		
	}
	@RequestMapping("/setStudentSignUp")
	public ModelAndView setStudentSignUp(Student student) {
		ModelAndView mv= new ModelAndView();
		studentRepo.save(student);
		mv.setViewName("welcome");
		return mv;
	}
	@RequestMapping("/setStudentLogin")
	public ModelAndView setStudentLogin(Student student,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Optional<Student> student_temp = studentRepo.findById(student.getStudentId());
		if(student_temp.isPresent()) {
			Optional<Student> student_login = studentRepo.findByStudentIdAndPassword(student.getStudentId(),student.getPassword());
			if(student_login.isPresent()) {
				Optional<Student> student_details = studentRepo.findById(student.getStudentId());
				session.setAttribute("student_optional",student_details);
				Student stu = student_details.get();
				session.setAttribute("student", stu);
				Optional<Address>stu_addr = null;
				boolean isNull=stu_addr.ofNullable(stu.getAddress()).isPresent();
				if(isNull) {
					session.setAttribute("address", stu.getAddress());
				}
				else {
					session.setAttribute("address", null);
				}
				session.setAttribute("student_name", stu.getStudent_name());
				session.setAttribute("student_id", stu.getStudentId());
				session.setAttribute("student_technology", stu.getTech());
				mv.addObject(stu);
				mv.setViewName("student_loginSuccess");
			}
			else {
				mv.setViewName("login_error");
			}
		}
		else {
			mv.setViewName("login_error");
		}
		return mv;
	}
	
	@RequestMapping("/getUpdateStudentDetails")
	public ModelAndView getUpdateStudentDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateStudentDetails");
		return mv;
	}
	
	@RequestMapping("/updateStudentDetails")
	public ModelAndView updateStudentDetails(Student student,HttpSession session) {
		Address address= student.getAddress();
		ModelAndView mv = new ModelAndView();
		Object student_obj= session.getAttribute("student");
		Student stu = (Student)student_obj;
		stu.setTech(student.getTech());
		student=studentRepo.save(stu);
		address.setStudent(student);
		Address addr = addressRepo.findByStudent_StudentId(student.getStudentId());
		if(addr!=null) {
			address.setAddressId(addr.getAddressId());
		}
		address=addressRepo.save(address);
		session.setAttribute("student", student);
		session.setAttribute("address", address);
		mv.addObject(stu);
		mv.setViewName("student_loginSuccess");
		return mv;
	}
	}
