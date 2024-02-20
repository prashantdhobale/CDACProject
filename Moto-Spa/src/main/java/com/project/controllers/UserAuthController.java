package com.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.daos.UserDao;
import com.project.dtos.AuthRequest;
import com.project.dtos.AuthResponse;
import com.project.jwt_utils.JwtUtils;
import com.project.services.UserServiceImpl;

//import com.app.dto.AuthRequest;
//import com.app.dto.AuthResponse;
//import com.app.jwt_utils.JwtUtils;

@RestController
@RequestMapping("/users")
public class UserAuthController {
	// dep : auth mgr
	
}
