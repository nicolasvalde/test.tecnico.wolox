package test.tecnico.wolox.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.tecnico.wolox.main.entities.Permission;

public interface IPermissionRepository extends JpaRepository<Permission, Integer> {

}
