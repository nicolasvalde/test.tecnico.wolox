package test.tecnico.wolox.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.repositories.IAlbumRepository;

@Service
public class AlbumServiceImpl implements IAlbumService {
	
	@Autowired
	IAlbumRepository albumRepository;
	
	@Override
	public Album[] findAll() {
		return albumRepository.findAll();
	}
	
	@Override
	public Album[] findByUserId(int userId) {
		return albumRepository.findByUserId(userId);
	}
}
