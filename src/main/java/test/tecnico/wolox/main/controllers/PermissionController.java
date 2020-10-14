package test.tecnico.wolox.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.services.IPermissionService;

@RestController
@RequestMapping(path = "api/v1/permissions")
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;

//	Endpoint deshabilitado ya que no es solicitado en el ejercicio
//	@GetMapping
//	public ResponseEntity<?> getAll() {
//		try {
//			return ResponseEntity.ok().body(permissionService.findAll());
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//	}

	@PostMapping(params = {"userId", "albumId"})
	@Operation(summary = "Crea un nuevo permiso vinculando un usuario y un álbum existentes")
	public ResponseEntity<?> save(@RequestBody Permission permission, @RequestParam int userId, @RequestParam int albumId) {
		try {
			return ResponseEntity.ok().body(permissionService.save(permission, userId, albumId));			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping(params = {"userId", "albumId"})
	@Operation(summary = "Modifica los permisos de un usuario respecto de un álbum específico")
	public ResponseEntity<?> update(@RequestBody Permission permission, @RequestParam int userId, @RequestParam int albumId) {
		return ResponseEntity.ok().body(permissionService.update(permission, userId, albumId));
	}
}
