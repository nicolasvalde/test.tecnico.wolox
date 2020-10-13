package test.tecnico.wolox.main.repositories.remote;

import test.tecnico.wolox.main.entities.Photo;

public interface IPhotoRepositoryRemote {

	public Photo[] findAll();

	public Photo[] findByAlbumId(int albumId);

}
