package com.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.Response;
import com.project.dtos.ServicePlanDTO;
import com.project.entities.ServicePlan;
import com.project.services.ServicesImpl;

@CrossOrigin(origins = "*")
@RestController
public class ServiceController {
	
	@Autowired
	private ServicesImpl planService;
	
	@GetMapping("/allservices")
	public ResponseEntity<?> getAllService(){
		System.out.println("inside ServiceController controller getAllService method");
		List<ServicePlanDTO> servicesDto = planService.getAllServices();
		return Response.success(servicesDto);
	}
	
	@GetMapping("/findservice/{id}")
	public ResponseEntity<?> findServiceById(@PathVariable("id") int serviceId){
		System.out.println("inside ServiceController controller findServiceById  method");
		Optional<ServicePlan> shop= planService.getServiceById(serviceId);
		return Response.success(shop);
	}

	
}
