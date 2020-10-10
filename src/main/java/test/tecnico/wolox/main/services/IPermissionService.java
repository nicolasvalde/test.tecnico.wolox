package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Permission;

@Service
public interface IPermissionService  {

	public List<Permission> findAll();
	
	public Permission save(Permission permission) throws Exception;
}
