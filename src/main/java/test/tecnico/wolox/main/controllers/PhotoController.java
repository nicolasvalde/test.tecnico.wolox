package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.entities.Photo;
import test.tecnico.wolox.main.services.IPhotoService;

@RestController
@RequestMapping(path = "api/v1/photos")
public class PhotoController {

	@Autowired
	IPhotoService photoService;

	@GetMapping
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok().body(photoService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(params = "userId")
	public ResponseEntity getByUserId(@RequestParam int userId) {
		try {
			return ResponseEntity.ok().body(photoService.findByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity create(@RequestBody Photo photo) {
		return ResponseEntity.ok(photoService.save(photo));
	}

}
