package test.tecnico.wolox.main.services;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Photo;

@Service
public interface IPhotoService {
	public Photo[] findAll();

	public Photo[] findByUserId(int userId);
}
