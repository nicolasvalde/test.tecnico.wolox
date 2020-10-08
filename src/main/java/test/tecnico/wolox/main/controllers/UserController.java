package test.tecnico.wolox.main.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.services.IUserService;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity create(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}

}
