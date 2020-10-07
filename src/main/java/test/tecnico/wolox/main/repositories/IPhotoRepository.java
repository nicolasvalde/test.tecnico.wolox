package test.tecnico.wolox.main.repositories;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Photo;

@Repository
public interface IPhotoRepository {
	public Photo[] findAll();
	public Photo[] findByUserId(int userId);
}
