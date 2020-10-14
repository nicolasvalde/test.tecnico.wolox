package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.wolox.main.services.ICommentService;

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentController {

	@Autowired
	private ICommentService commentService;

	@GetMapping(params = "name")
	public ResponseEntity<?> getByName(@RequestParam String name) {
		try {
			return ResponseEntity.ok().body(commentService.findByName(name));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(params = "userId")
	public ResponseEntity<?> getByUserId(@RequestParam int userId) {
		try {			
			return ResponseEntity.ok().body(commentService.findByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
