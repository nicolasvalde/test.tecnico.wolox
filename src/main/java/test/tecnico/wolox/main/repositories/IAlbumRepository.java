package test.tecnico.wolox.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Album;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Integer>{
	@Query(value =  "SELECT id,title,user_id FROM Albums WHERE user_id = ?1", nativeQuery = true)
	public List<Album> findByUserId(int id);
}

