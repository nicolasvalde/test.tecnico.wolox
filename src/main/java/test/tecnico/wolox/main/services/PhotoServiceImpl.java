package test.tecnico.wolox.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.entities.Photo;
import test.tecnico.wolox.main.repositories.AlbumRepositoryImpl;
import test.tecnico.wolox.main.repositories.IAlbumRepository;
import test.tecnico.wolox.main.repositories.IPhotoRepository;
import test.tecnico.wolox.main.repositories.PhotoRepositoryImpl;

@Service
public class PhotoServiceImpl implements IPhotoService {

	@Autowired
	IPhotoRepository photoRepositoryLocal;

	@Autowired
	PhotoRepositoryImpl photoRepositoryRemote;

	@Autowired
	IAlbumRepository albumRepositoryLocal;
	
	@Autowired
	AlbumRepositoryImpl albumRepositoryRemote;

	@Override
	public List<Photo> findAll() {
		
		Iterable<Photo> localPhotos = photoRepositoryLocal.findAll();
		
		Photo[] remotePhotos = photoRepositoryRemote.findAll();
		
		List<Photo> finalPhotosList = StreamSupport.stream(localPhotos.spliterator(), false).collect(Collectors.toList());
		
		for (Photo photo : remotePhotos) {
			finalPhotosList.add(photo);
		}
		
		return finalPhotosList;
	}

	@Override
	public List<Photo> findByUserId(int userId) {

		Album[] userAlbumsRemote = albumRepositoryRemote.findByUserId(userId);
		
		Iterable<Photo> userPhotosLocal = photoRepositoryLocal.findByUserId(userId);

		List<Photo> finalUserPhotosList = new ArrayList<Photo>();
		
		for (Album album : userAlbumsRemote) {
			Photo[] photosTemp = photoRepositoryRemote.findByAlbumId(album.getId());
			for (Photo photo : photosTemp) {
				finalUserPhotosList.add(photo);
			}
		}
		
		for (Photo photo : userPhotosLocal) {
			finalUserPhotosList.add(photo);
		}
				
		return finalUserPhotosList;
	}
	
	@Override
	public Photo save(Photo photo) {
		return photoRepositoryLocal.save(photo);
	}

}
