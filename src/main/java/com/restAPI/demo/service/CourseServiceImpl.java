package com.restAPI.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restAPI.demo.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(111, "Java Course", "Contains basic of Java"));
		list.add(new Course(222, "Python Course", "Contains basic of python"));
		list.add(new Course(333, "SQL Course", "Contains basic of SQl"));

	}
	
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourseById(long courseId) {
		// TODO Auto-generated method stub
		
		Course c= null;
		
		for(Course course : list) {
			if(course.getId()==courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
			
		});
		
		return course;
	}

	@Override
	public void deleteCourseById(Long valueOf) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=valueOf).collect(Collectors.toList());
	}
	
}
