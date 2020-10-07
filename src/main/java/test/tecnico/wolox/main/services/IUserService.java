package test.tecnico.wolox.main.services;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.User;

@Service
public interface IUserService {

	public User[] findAll();
}
