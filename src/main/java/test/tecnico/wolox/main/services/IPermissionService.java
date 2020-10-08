package test.tecnico.wolox.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import test.tecnico.wolox.main.entities.Permission;

@Service
public interface IPermissionService {

	public List<Permission> findAll();
}
