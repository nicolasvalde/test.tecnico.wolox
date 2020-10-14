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
	private IPermissionRepositoryLocal permissionRepositoryLocal;

	@Autowired
	private IPermissionDAO permissionDAO;

	@Autowired
	private IUserRepositoryLocal userRepositoryLocal;

	@Autowired
	private IAlbumRepositoryLocal albumRepositoryLocal;

	@Override
	public List<Permission> findAll() {
		return permissionRepositoryLocal.findAll();
	}

	@Override
	public Permission update(Permission permission, int userId, int albumId) {

		Permission p = permissionRepositoryLocal.findByParams(userId, albumId);

		p.setRead(permission.isRead());

		p.setWrite(permission.isWrite());

		permissionDAO.save(p);

		return p;
	}

	@Override
	public Permission save(Permission permission, int userId, int albumId) throws Exception {
	
		if (permissionRepositoryLocal.findByParams(userId, albumId) != null) {
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
	
			album = albumRepositoryLocal.findById(albumId).get();
	
			List<Permission> pListAlbum = album.getPermissions();
	
			pListAlbum.add(permission);
	
			user.setPermissions(pListAlbum);
	
			album = albumRepositoryLocal.save(album);
	
			/*
			 * Se actualiza la lista de permisos
			 * de un usario existente, lo que posibilita
			 * que se persistan las relaciones
			 */
	
			user = userRepositoryLocal.findById(userId).get();
	
			List<Permission> pListUser = user.getPermissions();
	
			pListUser.add(permission);
	
			user.setPermissions(pListUser);
	
			user = userRepositoryLocal.save(user);
	
			return pTemp;
		}
	
	}

}
