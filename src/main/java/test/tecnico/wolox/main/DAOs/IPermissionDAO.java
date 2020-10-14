package test.tecnico.wolox.main.DAOs;

import java.util.List;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;

@Repository
public interface IPermissionDAO {

	public Permission save(Permission permission);

}
