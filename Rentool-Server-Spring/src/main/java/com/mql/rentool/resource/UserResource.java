package com.mql.rentool.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mql.rentool.exception.UserNotFoundException;
import com.mql.rentool.persistence.model.User;
import com.mql.rentool.persistence.repository.UserRepository;


@RestController
public class UserResource {

	@Autowired
	private UserRepository UserRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return UserRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable long id) {
		Optional<User> user = UserRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		return user.get();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		UserRepository.deleteById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User User) {
		User savedUser = UserRepository.save(User);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {

		Optional<User> UserOptional = UserRepository.findById(id);

		if (!UserOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		UserRepository.save(user);

		return ResponseEntity.noContent().build();
	}
}