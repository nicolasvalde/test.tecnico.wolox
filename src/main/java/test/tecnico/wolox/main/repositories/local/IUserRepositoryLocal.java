package test.tecnico.wolox.main.repositories.local;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.User;

@Repository
public interface IUserRepositoryLocal extends JpaRepository<User, Integer> {
	@Query(value =  "SELECT DISTINCT u.* FROM USERS AS u JOIN PERMISSIONS AS p ON p.ALBUM_ID = ?1 AND u.ID = p.USER_ID AND p.READ = ?2 AND p.WRITE = ?3", nativeQuery = true)
	public List<User> findByAlbumAndPermissions(int albumId, boolean read, boolean write);
}
