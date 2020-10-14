package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.repositories.remote.ICommentRepositoryRemote;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentRepositoryRemote commentRepository;
	
	@Override
	public Object[] findByName(String name) {
		return commentRepository.findByName(name);
	}

	@Override
	public List<?> findByUserId(int userId) {
		return commentRepository.findByUserId(userId);
	}
}
