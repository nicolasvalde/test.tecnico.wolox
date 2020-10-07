package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.services.IPhotoService;

@RestController
@RequestMapping(path = "api/v1/photos")
public class PhotoController {

	@Autowired
	IPhotoService photoService;
	
	@GetMapping
	public ResponseEntity getAll(){
		try {			
			return ResponseEntity.ok().body(photoService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity getByUserId(@PathVariable int userId){
		try {			
			return ResponseEntity.ok().body(photoService.findByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
