package test.tecnico.wolox.main.services;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Album;

@Service
public interface IAlbumService {
	public Album[] findAll();
}
