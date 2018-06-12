package com.hui.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hui.springboot.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService cs;
	
	
	@GetMapping("/topic/{topicId}")
	public List<Course> getAllCourses(@PathVariable String topicId){
		
		return cs.getAllCourse(topicId);
	}
	
	@GetMapping("/topic/{topicId}/course/{id}")
	public Course getCourse( @PathVariable String id) {
		
		return cs.getCourse(id);
	}
	
	@PostMapping("/topic/{topicId}/course")
	public void addCourse(@RequestBody Course course ,@PathVariable String topicId) {
		Topic tp = new Topic(topicId ,"" ,"");
		course.setTopic(tp);
		cs.addCourse(course);
		
	}
	
	@PutMapping("/topic/{topicId}/course")
	public void updateCourse(@RequestBody Course course ,@PathVariable String topicId) {
		Topic tp = new Topic(topicId ,"" ,"");
		course.setTopic(tp);
		cs.updateCourse(course);
		
	}
	
	@DeleteMapping("/topic/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		cs.deleteCourse(id);
	}
}
