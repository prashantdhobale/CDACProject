package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.RepairShopDTO;
import com.project.dtos.Response;
import com.project.services.RepairShopServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class RepairShopController {
	
	@Autowired
	private RepairShopServiceImpl repairShopService;
	
	
	@GetMapping("/getallshops")
	public ResponseEntity<?> getAllRepairShops(){
		System.out.println("inside RepairShopController controller  get AllRepairShops method");
		List<RepairShopDTO> shops= repairShopService.getAllShops();
		return Response.success(shops);
	}
	
	@GetMapping("/shop/{city}")
	public ResponseEntity<?> getShopByCity(@PathVariable("city") String city){
		System.out.println("inside RepairShopController controller getShopByCity method");
		List<RepairShopDTO> shops= repairShopService.getShopsByCity(city);
		return Response.success(shops);
	}
	
	
}
