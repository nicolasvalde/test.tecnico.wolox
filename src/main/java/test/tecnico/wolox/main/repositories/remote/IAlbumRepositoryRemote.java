package test.tecnico.wolox.main.repositories.remote;

import test.tecnico.wolox.main.entities.Album;

public interface IAlbumRepositoryRemote {

	public Album[] findAll();

	public Album[] findByUserId(int userId);

}
