package com.oussema.pieces.repos;



import org.springframework.data.jpa.repository.JpaRepository;
import com.oussema.pieces.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
	
}

