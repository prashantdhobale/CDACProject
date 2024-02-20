package com.project.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.daos.UserDao;
import com.project.dtos.AuthRequest;
import com.project.dtos.AuthResponse;
import com.project.dtos.Credential;
import com.project.dtos.Response;
import com.project.dtos.UserDTO;
import com.project.dtos.VehicleDTO;
import com.project.entities.User;
import com.project.entities.Vehicle;
import com.project.jwt_utils.JwtUtils;
import com.project.services.UserServiceImpl;

@CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RequestMapping(value = "/users")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

//	@PostMapping("/signin")
//	public ResponseEntity<?> login(@RequestBody Credential cred) {
//		
//		System.out.println("inside UserController controller login method");
//		UserDTO userDto = userService.findUserByEmailAndPassword(cred);
//
//		if (userDto == null) {
//			System.out.println(userDto);
//			return Response.error("user not found");
//		}
//		return Response.success(userDto);
//	}
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserDao userDao;
	
	//dep : jwt utils 
	@Autowired
	private JwtUtils jwtUtils;

	public UserController() {
		System.out.println("in user auth controller");
	}

	// http://host:port/users/signin , method=POST ,
	// req : AuthRequest : DTO
	// resp : AuthResp : message , jwt
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody @Valid AuthRequest request) {
		System.out.println("in user signin " + request);
		// wrap use's un verified credentials in the auth object
		UsernamePasswordAuthenticationToken authToken = 
				new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		// invoke Auth mgr's authenticate method
		Authentication verifiedCredentials = manager.authenticate(authToken);
		UserDTO userDto = userService.findUserByEmailAndPassword(new Credential(request.getEmail(), request.getPassword()));

		//=>no auth exc => auth success , generate auth resp containing genearated JWT
		return ResponseEntity.ok(new AuthResponse("Successsful Login!",
				jwtUtils.generateJwtToken(verifiedCredentials), userDto));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		System.out.println("inside UserController controller signup  method");
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	//update user
	
	@PutMapping("/edituser/{id}")
	public ResponseEntity<?> editUser(@PathVariable("id") int id,@RequestBody UserDTO userDto) {
		return ResponseEntity.ok(userService.editUser(id,userDto));
	}
	
	// add vehicle 
	@PostMapping("/vehicle/addvehicle")
		public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
			return ResponseEntity.ok(userService.saveVehicle(vehicle));
			}
		
	

	//edit vehicle
	@PutMapping("/vehicle/editvehicle/{id}")
	public ResponseEntity<?> editService(@PathVariable("id") int id,@RequestBody VehicleDTO vehicleDto) {
		return ResponseEntity.ok(userService.editVehicle(id,vehicleDto));
	}
	
	//FIND USER
		@GetMapping("/finduser/{id}")
		public ResponseEntity<?> findUserById(@PathVariable("id") int userId){
			Optional<User> user= userService.getUserById(userId);
			return Response.success(user);
		}

	
}
