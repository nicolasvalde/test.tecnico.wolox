package test.tecnico.wolox.main.repositories;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Album;

@Repository
public interface IAlbumRepository {
	public Album[] findAll();

	public Album[] findByUserId(int userId);
}
