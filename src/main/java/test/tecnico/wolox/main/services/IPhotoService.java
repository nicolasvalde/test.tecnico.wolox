package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Photo;

@Service
public interface IPhotoService {
	public List<Photo> findAll();

	public List<Photo> findByUserId(int userId);

	public Photo save(Photo photo);
}
