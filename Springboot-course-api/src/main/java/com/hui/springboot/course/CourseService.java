package com.hui.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CourseService {
	
	@Autowired
	private CourseRepository cr;
	
	public List<Course> getAllCourse( String topicId){
		List<Course> courses = new ArrayList<>();
		cr.findCourseByTopicId(topicId).forEach(courses:: add);
		
		return courses;
	}
	
	
	public Course getCourse(String id) {
		
		return cr.findOne(id);
	}
	
	public void addCourse(Course course) {
		cr.save(course);
	}
	public void updateCourse(Course course) {
		cr.save(course);
	}
	
	public void deleteCourse(String id) {
		cr.delete(id);
	}

}
