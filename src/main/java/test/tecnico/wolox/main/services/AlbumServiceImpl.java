package test.tecnico.wolox.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.DAOs.IPermissionDAO;
import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.repositories.local.IAlbumRepositoryLocal;
import test.tecnico.wolox.main.repositories.local.IUserRepositoryLocal;
import test.tecnico.wolox.main.repositories.remote.AlbumRepositoryImplRemote;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private IAlbumRepositoryLocal albumRepositoryLocal;

	@Autowired
	private AlbumRepositoryImplRemote albumRepositoryRemote;

	@Autowired
	private IPermissionDAO permissionDAO;

	@Autowired
	private IUserRepositoryLocal userRepository;

	@Override
	public List<Album> findAll() {

		Iterable<Album> localAlbums = albumRepositoryLocal.findAll();

		Album[] remoteAlbums = albumRepositoryRemote.findAll();

		List<Album> finalAlbums = StreamSupport.stream(localAlbums.spliterator(), false).collect(Collectors.toList());

		for (Album album : remoteAlbums) {
			finalAlbums.add(album);
		}

		return finalAlbums;
	}

	@Override
	public List<Album> findByUserId(int userId) {

		List<Album> localAlbums = albumRepositoryLocal.findByUserId(userId);

		Album[] remoteAlbums = albumRepositoryRemote.findByUserId(userId);

		List<Album> finalAlbums = new ArrayList();

		for (Album albumTemp : localAlbums) {
			finalAlbums.add(albumTemp);
		}
		for (Album albumTemp : remoteAlbums) {
			finalAlbums.add(albumTemp);
		}

		return finalAlbums;
	}

	@Override
	public Album save(Album album) {

		/*
		 * Primero se persiste el permiso, que al crear
		 * un album nuevo siempre sera true para read y write
		 */
		
		Permission permission = new Permission();

		permission.setRead(true);

		permission.setWrite(true);

		permission = permissionDAO.save(permission);

		/*
		 * Segundo se agrega la relacion del permiso creado
		 * con el usuario creador del album, agregandose a los
		 * permisos que pudiera tener anteriormente
		 */
		
		User user = new User();

		user = userRepository.findById(album.getUserId()).get();

		List<Permission> pUserList = user.getPermissions();

		pUserList.add(permission);

		user.setPermissions(pUserList);
		
		user = userRepository.save(user);
		
		/*
		 * Tercero se agregan los permisos al album y se 
		 * persiste con sus relaciones
		 */
		
		List<Permission> pAlbumList = new ArrayList();
	
		pAlbumList.add(permission);
		
		album.setPermissions(pAlbumList);

		return albumRepositoryLocal.save(album);
	}
}
