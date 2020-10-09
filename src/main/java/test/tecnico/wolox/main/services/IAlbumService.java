package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Album;

@Service
public interface IAlbumService {
	public List<Album> findAll();
	
	public List<Album> findByUserId(int userId);
	
	public Album save(Album album);
}
