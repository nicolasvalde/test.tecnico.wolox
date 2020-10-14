package test.tecnico.wolox.main.repositories.local;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;

@Repository
public interface IPermissionRepositoryLocal extends JpaRepository<Permission, Integer> {

	@Query(value =  "SELECT p.* FROM permissions p", nativeQuery = true)
	public List<Permission> findAll();
	
	@Query(value =  "select p.* from permissions p where p.user_id = ?1 and p.album_id = ?2", nativeQuery = true)
	public Permission findByParams(int userId, int albumId);
	
}
