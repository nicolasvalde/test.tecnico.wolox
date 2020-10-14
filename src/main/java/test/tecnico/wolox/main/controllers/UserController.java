package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.services.IUserService;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	@Operation(summary = "Muestra todos los usuarios")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(path = "/getByAlbumPermissions", params = { "albumId", "read", "write" })
	@Operation(summary = "Muestra los usuarios que tienen un permiso determinado respecto de un álbum específico")
	public ResponseEntity<?> getByAlbumPermissions(@RequestParam(required = true) int albumId,
			@RequestParam boolean read, @RequestParam boolean write) {
		try {
			return ResponseEntity.ok().body(userService.findByAlbumAndPermissions(albumId, read, write));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	@Operation(summary = "Crea un nuevo usuario")
	public ResponseEntity<?> create(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.save(user));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
