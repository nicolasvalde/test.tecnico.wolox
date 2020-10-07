package test.tecnico.wolox.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Photo;
import test.tecnico.wolox.main.repositories.IPhotoRepository;

@Service
public class PhotoServiceImpl implements IPhotoService {

	@Autowired
	IPhotoRepository photoRepository;
	
	@Override
	public Photo[] findAll() {
		return photoRepository.findAll();
	}

}
