package test.tecnico.wolox.main.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import test.tecnico.wolox.main.entities.Photo;

@Repository
public class PhotoRepositoryImpl implements IPhotoRepository {

	private String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Photo[] findAll() {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/photos", Photo[].class);
	}

	@Override
	public Photo[] findByUserId(int userId) {
		return restTemplate.getForObject(EXTERNAL_API_URL+ "/user/" + userId + "/photos", Photo[].class);
	}

}
