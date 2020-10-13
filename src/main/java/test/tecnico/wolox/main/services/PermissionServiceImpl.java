package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.DAOs.IPermissionDAO;
import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.repositories.local.IAlbumRepositoryLocal;
import test.tecnico.wolox.main.repositories.local.IPermissionRepositoryLocal;
import test.tecnico.wolox.main.repositories.local.IUserRepositoryLocal;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionRepositoryLocal permissionRepository;

	@Autowired
	private IPermissionDAO permissionDAO;

	@Autowired
	private IUserRepositoryLocal userRepository;

	@Autowired
	private IAlbumRepositoryLocal albumRepository;

	@Override
	public List<Permission> findAll() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission update(Permission permission, int userId, int albumId) {

		Permission p = permissionDAO.findByParams(userId, albumId);

		p.setRead(permission.isRead());

		p.setWrite(permission.isWrite());

		permissionDAO.save(p);

		return p;
	}

	@Override
	public Permission save(Permission permission, int userId, int albumId) throws Exception {
	
		if (permissionDAO.findByParams(userId, albumId) != null) {
			throw new Exception("Ya existe ese permiso");
		} else {
	
			Permission pTemp = permissionDAO.save(permission);
	
			User user = new User();
			
			Album album = new Album();
	
			/*
			 * Se actualiza la lista de permisos
			 * de un album existente, lo que posibilita
			 * que se persistan las relaciones con los permisos
			 */
	
			album = albumRepository.findById(albumId).get();
	
			List<Permission> pListAlbum = album.getPermissions();
	
			pListAlbum.add(permission);
	
			user.setPermissions(pListAlbum);
	
			album = albumRepository.save(album);
	
			/*
			 * Se actualiza la lista de permisos
			 * de un usario existente, lo que posibilita
			 * que se persistan las relaciones
			 */
	
			user = userRepository.findById(userId).get();
	
			List<Permission> pListUser = user.getPermissions();
	
			pListUser.add(permission);
	
			user.setPermissions(pListUser);
	
			user = userRepository.save(user);
	
			return pTemp;
		}
	
	}

}
