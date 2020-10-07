package test.tecnico.wolox.main.repositories;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.User;

@Repository
public interface IUserRepository {
	
	public User[] findAll();
}
