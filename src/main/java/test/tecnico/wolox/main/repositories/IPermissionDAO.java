package test.tecnico.wolox.main.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;

@Repository
public interface IPermissionDAO {

	public Permission save(Permission permission);
	
	public List<Permission> findAll();

	public Permission findByParams(int userId, int albumId);

}
