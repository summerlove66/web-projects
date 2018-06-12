package com.hui.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService ts;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return ts.getAllTopics();		
				
	}
	
	@RequestMapping("/topics/{topicId}")
	public Topic  getTopic(@PathVariable String topicId) {
		
		return ts.getTopic(topicId);
	}
	
	@RequestMapping(method = RequestMethod.POST , value ="/topics")
	public void addTopic(@RequestBody Topic tp) {
		
		ts.addTopic(tp);
	}
	
	@RequestMapping(method =RequestMethod.DELETE ,value ="/topics/{topicId}")
	public void deleteTopic(@PathVariable String topicId) {
		ts.deleteTopic(topicId);
	}
	
}
