package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import test.tecnico.wolox.main.services.ICommentService;

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentController {

	@Autowired
	private ICommentService commentService;

	@GetMapping(path =  "/getByName", params = "name")
	@Operation(summary = "Filtra y muestra los comentarios por su campo 'name'")
	public ResponseEntity<?> getByName(@RequestParam String name) {
		try {
			return ResponseEntity.ok().body(commentService.findByName(name));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(path =  "/getByUserId", params = "userId")
	@Operation(summary = "Filtra y muestra los comentarios a partir del ID de un usuario")
	public ResponseEntity<?> getByUserId(@RequestParam int userId) {
		try {			
			return ResponseEntity.ok().body(commentService.findByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
