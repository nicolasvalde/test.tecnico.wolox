package test.tecnico.wolox.main.repositories.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import test.tecnico.wolox.main.entities.Album;

@Repository
public class AlbumRepositoryImplRemote implements IAlbumRepositoryRemote {

	private String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Album[] findAll() {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/albums", Album[].class);
	}

	@Override
	public Album[] findByUserId(int userId) {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/albums?userId=" + userId, Album[].class);
	}

}
