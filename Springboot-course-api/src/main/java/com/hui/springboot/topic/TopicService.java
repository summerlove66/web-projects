package com.hui.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topics;
	
	
	public List<Topic> getAllTopics () {
		
		List<Topic> topicsList = new ArrayList<>();
		for(Topic tp:  topics.findAll()) {
			topicsList.add(tp);
		}
		return topicsList;
	}
	
	
	public Topic getTopic(String topicId) {
		
		for(Topic tp :topics.findAll()) {
			
			if (tp.getId().equals(topicId)) {
				return tp;
			}
		}
		
		return  null;
}

	
	public void addTopic(Topic tp) {
		topics.save(tp);
	}
	
	
	public void deleteTopic(String topicId) {
		topics.delete(topicId);
	}
}