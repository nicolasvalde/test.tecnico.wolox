package test.tecnico.wolox.main.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.User;

@Service
public interface IUserService {

	public List<User> findAll();
	
	public User save(User user);
}
