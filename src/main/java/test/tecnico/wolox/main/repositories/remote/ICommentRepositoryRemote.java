package test.tecnico.wolox.main.repositories.remote;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepositoryRemote {

	public Object[] findByName(String name);

	public List<?> findByUserId(int userId);

}
