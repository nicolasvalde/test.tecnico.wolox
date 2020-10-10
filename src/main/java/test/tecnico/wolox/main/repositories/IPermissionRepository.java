package test.tecnico.wolox.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.PermissionId;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, PermissionId> {

}
