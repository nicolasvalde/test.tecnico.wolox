package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.services.IAlbumService;

@RestController
@RequestMapping(path = "api/v1/albums")
public class AlbumController {

	@Autowired
	IAlbumService albumService;

	@GetMapping
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok().body(albumService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(params = "userId")
	public ResponseEntity getByUserId(@RequestParam int userId) {
		try {
			return ResponseEntity.ok().body(albumService.findByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
