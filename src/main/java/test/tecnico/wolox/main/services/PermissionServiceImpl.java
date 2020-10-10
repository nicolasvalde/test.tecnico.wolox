package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.PermissionId;
import test.tecnico.wolox.main.repositories.IPermissionRepository;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionRepository permissionRepository;

	@Override
	public List<Permission> findAll() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission save(Permission permission) throws Exception {

		PermissionId p = new PermissionId(permission.getUserId(), permission.getAlbumId());
		
		
		if(permissionRepository.existsById(p)) {
			throw new Exception("Ya existe ese permiso");
		} else {
			System.out.println(permissionRepository.existsById(p));
		}
		
		return permissionRepository.saveAndFlush(permission);

	}

}
