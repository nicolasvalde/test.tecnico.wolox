package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.PermissionId;
import test.tecnico.wolox.main.repositories.IPermissionDAO;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionDAO permissionRepository;

	@Override
	public List<Permission> findAll() {
		return null;
//		return permissionRepository.findAll();
	}

	@Override
	public Permission save(Permission permission) throws Exception {

//		PermissionId p = new PermissionId(permission.getUser().getId(), permission.getAlbum().getId());
//		
//		
//		if(permissionRepository.existsById(p)) {
//			throw new Exception("Ya existe ese permiso");
//		} else {
//			System.out.println(permissionRepository.existsById(p));
//		}
		
		return permissionRepository.save(permission);

	}

}
