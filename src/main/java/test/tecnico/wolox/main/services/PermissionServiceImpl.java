package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.repositories.IPermissionRepository;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	IPermissionRepository permissionRepository;
	
	@Override
	public List<Permission> findAll() {
		return (List<Permission>) permissionRepository.findAll();
	}
}
