package test.tecnico.wolox.main.repositories.remote;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.User;

@Repository
public interface IUserRepositoryRemote {

	public User[] findAll();

}
