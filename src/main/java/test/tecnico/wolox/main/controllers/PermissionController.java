package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.services.IPermissionService;

@RestController
@RequestMapping(path = "api/v1/permissions")
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;

	@GetMapping
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok().body(permissionService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity save(@RequestBody Permission permission) {
		try {
			return ResponseEntity.ok().body(permissionService.save(permission));			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
