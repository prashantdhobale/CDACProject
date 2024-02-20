package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.JobCardDTO;
import com.project.dtos.Response;
import com.project.services.JobCardServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class JobCardController {
	
	@Autowired
	private JobCardServiceImpl jobCardService;
	
	
	
	@GetMapping("/jobcard/{id}")
	public ResponseEntity<?> findJobCardByUserId(@PathVariable("id") int id){
		System.out.println("inside jobCard controller getVehicle method");
		JobCardDTO jCard= jobCardService.getJobCardByUserId(id);		
		return Response.success(jCard);
	}
	
	@PostMapping("/addjobcard")
	public ResponseEntity<?> addJobcard(@RequestBody JobCardDTO jCard) {
		System.out.println("inside JobCardController with request "+jCard);
		return ResponseEntity.ok(jobCardService.booking(jCard));
	}

}
