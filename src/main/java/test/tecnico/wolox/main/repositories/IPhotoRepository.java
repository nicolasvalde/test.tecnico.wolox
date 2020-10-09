package test.tecnico.wolox.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Photo;

@Repository
public interface IPhotoRepository extends JpaRepository<Photo, Integer>{
	@Query(value =  "SELECT p.* FROM PHOTOS AS p JOIN ALBUMS AS a ON a.id=p.album_id JOIN USERS AS u ON a.user_id = ?1", nativeQuery = true)
	public List<Photo> findByUserId(int id);
}
