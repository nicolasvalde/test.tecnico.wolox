package test.tecnico.wolox.main.repositories.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import test.tecnico.wolox.main.entities.User;

@Repository
public class UserRepositoryImplRemote implements IUserRepositoryRemote {

	private String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User[] findAll() {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/users", User[].class);
	}

}
