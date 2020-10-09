package test.tecnico.wolox.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.repositories.AlbumRepositoryImpl;
import test.tecnico.wolox.main.repositories.IAlbumRepository;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	IAlbumRepository albumRepositoryLocal;

	@Autowired
	AlbumRepositoryImpl albumRepositoryRemote;

	@Override
	public List<Album> findAll() {

		Iterable<Album> localAlbums = albumRepositoryLocal.findAll();

		Album[] remoteAlbums = albumRepositoryRemote.findAll();

		List<Album> finalAlbums = StreamSupport.stream(localAlbums.spliterator(), false).collect(Collectors.toList());

		for (Album album : remoteAlbums) {
			finalAlbums.add(album);
		}

		return finalAlbums;
	}

	@Override
	public List<Album> findByUserId(int userId) {

		List<Album> localAlbums = albumRepositoryLocal.findByUserId(userId);

		Album[] remoteAlbums = albumRepositoryRemote.findByUserId(userId);

		List<Album> finalAlbums = new ArrayList();

		for (Album albumTemp : localAlbums) {
			finalAlbums.add(albumTemp);
		}
		for (Album albumTemp : remoteAlbums) {
			finalAlbums.add(albumTemp);
		}

		return finalAlbums;
	}

	@Override
	public Album save(Album album) {
		return albumRepositoryLocal.save(album);
	}
}
