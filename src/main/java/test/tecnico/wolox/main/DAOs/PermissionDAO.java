package test.tecnico.wolox.main.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.Album;
import test.tecnico.wolox.main.entities.Permission;
import test.tecnico.wolox.main.entities.User;

@Repository
public class PermissionDAO implements IPermissionDAO {

	@PersistenceContext
	EntityManager entityManager;

//	@Override
//	@Transactional
//	public List<Permission> findAll() {
//		List<Permission> permissions = entityManager. createQuery("SELECT p FROM permission p").getResultList();
//		
//		return permissions;
//	}
	
	@Override
	@Transactional
	public Permission findByParams(int userId, int albumId) {
		
		Query query =  entityManager.createNativeQuery("select p.* from permissions p where p.user_id = :userId and p.album_id = :albumId", Permission.class);
		
		query.setParameter("userId", userId);
		
		query.setParameter("albumId", albumId);
		if( query.getResultList().size() > 0) {			
			Object p = query.getResultList().get(0);
			return (Permission) p;
		} else {
			return null;
		}
		
	}
	
	@Override
	@Transactional
	public Permission save(Permission permission) {
				
		entityManager.persist(permission);
		
		return entityManager.find(Permission.class, permission.getId());
	}

}
