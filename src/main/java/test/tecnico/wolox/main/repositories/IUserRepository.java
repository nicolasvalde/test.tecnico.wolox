package test.tecnico.wolox.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.tecnico.wolox.main.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
