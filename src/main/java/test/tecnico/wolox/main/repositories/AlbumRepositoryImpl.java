package test.tecnico.wolox.main.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import test.tecnico.wolox.main.entities.Album;

@Repository
public class AlbumRepositoryImpl implements IAlbumRepository {

	private String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Album[] findAll() {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/albums", Album[].class);
	}

	@Override
	public Album[] findByUserId(int userId) {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/users/" + userId + "/albums", Album[].class);
	}

}
