package test.tecnico.wolox.main.repositories.remote;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Photo;

@Repository
public interface IPhotoRepositoryRemote {

	public Photo[] findAll();

	public Photo[] findByAlbumId(int albumId);

}
