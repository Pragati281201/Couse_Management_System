package com.sbcrud.servicei;

import com.sbcrud.model.Course;


public interface CourseServiceI {
	
//	Abstract methods
	
    public void saveCourse(Course c);
	
	public Iterable<Course> getAllCourses();
	
	public void deleteCourse(int id);

	public Course getCourseById(int id);
	
	public Course loginCourse(String username, String password);

	
	

}
