package com.restAPI.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.demo.entity.Course;
import com.restAPI.demo.service.CourseService;


@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Home Page from CRUD";
	}

	@GetMapping("/course")
	public List<Course> getCourse() {

		return this.courseService.getCourse();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourseByID(@PathVariable String courseId) {
		
		return this.courseService.getCourseById(Long.valueOf(courseId));
	}

	@PostMapping(path="/course", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable String courseId) {
		try {
		this.courseService.deleteCourseById(Long.valueOf(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
	
}
