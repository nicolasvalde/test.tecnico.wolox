package test.tecnico.wolox.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository accountRespository;
	
	@Override
	public User[] findAll() {
		return accountRespository.findAll();
	}

	
}
