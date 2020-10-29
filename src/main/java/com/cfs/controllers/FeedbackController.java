package com.cfs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfs.exception.FeedbackDatabaseException;
import com.cfs.exception.FeedbackNotFoundException;
import com.cfs.model.Feedback;
import com.cfs.model.Response;
import com.cfs.services.SequenceService;


@RestController
@RequestMapping("/cfs")
public class FeedbackController {

	private final String KEY="feedback";
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SequenceService seqId;

	@GetMapping("/feedback")
	public Response<List<Feedback>>getAllFeedback(){

		List<Feedback> feedbackList = mongoTemplate.findAll(Feedback.class);
		if(feedbackList == null)
			throw new FeedbackNotFoundException("No Feedback Found");

		return new Response<List<Feedback>>(feedbackList, HttpStatus.OK.value(),"success");
	}

	@GetMapping("/feedback/{id}")
	public Response<Feedback> getFeedbackById(@PathVariable long id){


		Feedback feedback = mongoTemplate.findById(id, Feedback.class);
		if(feedback == null)
			throw new FeedbackNotFoundException("Feedback Not Found");

		return new Response<Feedback>(feedback, HttpStatus.OK.value(), "success");
	}

	@PostMapping("/feedback")
	public Response<Feedback> saveFeedback(@RequestBody Feedback newFeedback){

		newFeedback.setId(seqId.getNextSequenceId(KEY));
		
		Feedback feedback = mongoTemplate.save(newFeedback);
		if(feedback == null) {
			throw new FeedbackDatabaseException("Unable to save feedback");
		}
		return new Response<Feedback>(feedback, HttpStatus.OK.value(), "success");
	}

	@PutMapping("/feedback")
	public Response<Feedback> updateFeedback(@RequestBody Feedback modifiedFeedback){

		Feedback feedback = mongoTemplate.findById(modifiedFeedback.getId(), Feedback.class);
		if(feedback == null)
			throw new FeedbackNotFoundException("Feedback Not Found");

		feedback = mongoTemplate.save(modifiedFeedback);
		if(feedback == null) {
			throw new FeedbackDatabaseException("Unable to save feedback");
		}

		return new Response<Feedback>(feedback, HttpStatus.OK.value(), "success");
	}

	@DeleteMapping("/feedback/{id}")
	public Response<Boolean> deleteFeedbackById(@PathVariable long id){

		Feedback feedback = mongoTemplate.findById(id, Feedback.class);
		if(feedback == null)
			throw new FeedbackNotFoundException("Feedback Not Found");

		Boolean result = mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Feedback.class).wasAcknowledged();
		return new Response<Boolean>(result, HttpStatus.OK.value(), "success");
	}

}
