package com.tourism.comparahoteles.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.comparahoteles.models.User;
import com.tourism.comparahoteles.payload.request.UpdateRequest;
import com.tourism.comparahoteles.payload.response.MessageResponse;
import com.tourism.comparahoteles.repository.RoleRepository;
import com.tourism.comparahoteles.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
		try {
			List<User> users = new ArrayList<User>();

			if (name == null)
				userRepository.findAll().forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<?> deleteUserByUsername(@PathVariable("username") Long username) {
		try {
			userRepository.deleteById(username);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<?> updateUser(@PathVariable("username") String username,
			@Valid @RequestBody UpdateRequest updateRequest) {

		if (userRepository.existsByUsername(updateRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(updateRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		Optional<User> updateUser = userRepository.findByUsername(username);
		if (updateUser.isPresent()) {

			User userPresent = updateUser.get();
			userPresent.setUsername(updateRequest.getUsername());
			userPresent.setEmail(updateRequest.getEmail());
			userPresent.setPassword(encoder.encode(updateRequest.getPassword()));
			return new ResponseEntity<>(userRepository.save(userPresent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
