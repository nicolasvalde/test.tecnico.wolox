package test.tecnico.wolox.main.repositories.remote;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Album;

@Repository
public interface IAlbumRepositoryRemote {

	public Album[] findAll();

	public Album[] findByUserId(int userId);

}
