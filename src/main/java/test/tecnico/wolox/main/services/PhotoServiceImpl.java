package test.tecnico.wolox.main.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.entities.Photo;
import test.tecnico.wolox.main.repositories.IAlbumRepository;
import test.tecnico.wolox.main.repositories.IPhotoRepository;

@Service
public class PhotoServiceImpl implements IPhotoService {

	@Autowired
	IPhotoRepository photoRepository;

	@Autowired
	IAlbumRepository albumRepository;

	@Override
	public Photo[] findAll() {
		return photoRepository.findAll();
	}

	@Override
	public Photo[] findByUserId(int userId) {

		Album[] userAlbums = albumRepository.findByUserId(userId);

		List<Photo> userPhotos = new ArrayList<Photo>();

		for (Album album : userAlbums) {
			Photo[] photosTemp = photoRepository.findByAlbumId(album.getId());
			for (Photo photo : photosTemp) {
				userPhotos.add(photo);
			}
		}

		Photo[] photos = new Photo[userPhotos.size()];
		
		photos = userPhotos.toArray(photos);
		
		return userPhotos.toArray(photos);
	}

}
