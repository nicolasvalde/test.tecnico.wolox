package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICommentService {

	public Object[] findByName(String name);

	public List<?> findByUserId(int userId);

}
