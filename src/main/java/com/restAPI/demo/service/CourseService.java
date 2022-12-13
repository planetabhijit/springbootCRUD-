package com.restAPI.demo.service;

import java.util.List;

import com.restAPI.demo.entity.Course;

public interface CourseService {

	public List<Course> getCourse();

	public Course getCourseById(long courseId);
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourseById(Long valueOf);
}
