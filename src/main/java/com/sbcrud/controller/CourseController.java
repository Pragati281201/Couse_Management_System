package com.sbcrud.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbcrud.model.Course;
import com.sbcrud.servicei.CourseServiceI;


@Controller
public class CourseController {
	
	@Autowired
	CourseServiceI ci;
	
	@RequestMapping("/")
	public String homapage() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String regPage() {
		return "register";
	}
	
	@RequestMapping("/loginsuccess")
	public String loginsuccess(Model m, @RequestParam("username") String un, 
			@RequestParam("password") String ps) 
	{
		Course singleCourse = ci.loginCourse(un, ps);
		
		if(singleCourse == null && un.equals("admin") && ps.equals("1234")) {
			Iterable<Course> allCourses = ci.getAllCourses();
			m.addAttribute("courseList",allCourses);

			return "loginsuccess";
		}
		else if(singleCourse != null) {
			List<Course> singleCourseList = new ArrayList<Course>();
			singleCourseList.add(singleCourse);
			m.addAttribute("courseList", singleCourseList);
			return "loginsuccess";
		}
		else
		{
			return "login";
		}
		
	}
	
	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute Course c) {
		System.out.println("Course Id : " +c.getId());
		System.out.println("Course Name : "+c.getCourseName());

		System.out.println();
		ci.saveCourse(c);
		
		return "login";
	}
	
	@RequestMapping("/delete")
	public String deleteCourse(@RequestParam("id") int id, Model m) {
		ci.deleteCourse(id);
		Iterable<Course> allCourses = ci.getAllCourses();
		m.addAttribute("courseList",allCourses);
		return "loginsuccess";
	}
	
	@RequestMapping("/edit")
	public String editCourse(@RequestParam("id") int id, Model m) {
		Course course = ci.getCourseById(id);
		m.addAttribute("courses", course);
		System.out.println(course.getCourseName());
		return "edit";
	}
	@RequestMapping("/update")
	public String updateCourse(@ModelAttribute Course cm, Model m)
	{
		ci.saveCourse(cm);
		Iterable<Course> allCourses = ci.getAllCourses();
		m.addAttribute("courseList",allCourses);
		return "loginsuccess";
	}

	
	
	

}
