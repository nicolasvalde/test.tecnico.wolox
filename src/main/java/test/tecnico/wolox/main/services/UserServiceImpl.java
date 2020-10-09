package test.tecnico.wolox.main.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.User;
import test.tecnico.wolox.main.repositories.IUserRepository;
import test.tecnico.wolox.main.repositories.UserRepositoryImpl;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRespositoryLocal;
	
	@Autowired 
	UserRepositoryImpl userRepositoryRemote;

	@Override
	public List<User> findAll() {
		
		Iterable<User> localUsers = userRespositoryLocal.findAll();
		
		User[] remoteUsers = userRepositoryRemote.findAll();
		
		List<User> finalUsersList =  StreamSupport.stream(localUsers.spliterator(), false).collect(Collectors.toList());
		
		for (User user : remoteUsers) {
			finalUsersList.add(user);
		}
		
		return finalUsersList;
	}

	@Override
	public User save(User user) {
		return userRespositoryLocal.save(user);
	}
}
