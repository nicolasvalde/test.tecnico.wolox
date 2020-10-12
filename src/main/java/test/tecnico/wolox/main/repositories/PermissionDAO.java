package test.tecnico.wolox.main.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Permission;

@Repository
public class PermissionDAO implements IPermissionDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public Permission save(Permission permission) {
				
		entityManager.persist(permission);
		
		return entityManager.find(Permission.class, permission.getId());
	}

}
