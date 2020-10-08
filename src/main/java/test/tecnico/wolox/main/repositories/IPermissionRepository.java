package test.tecnico.wolox.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;

@Repository
public interface IPermissionRepository extends CrudRepository<Permission, Integer> {

}
