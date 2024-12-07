package com.sbcrud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbcrud.model.Course;
import com.sbcrud.repository.CourseRepository;
import com.sbcrud.servicei.CourseServiceI;

@Service
public class CourseServiceImpl implements CourseServiceI{

	@Autowired
	CourseRepository cr;

	@Override
	public void saveCourse(Course c) {
		System.out.println("In service Layer : " +c.getCourseName());
		cr.save(c);
	}

	@Override
	public Iterable<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id);
	}

	@Override
	public Course loginCourse(String username, String password) {
		// TODO Auto-generated method stub
		return cr.findByUsernameAndPassword(username, password);
	}

	
	
     
}
