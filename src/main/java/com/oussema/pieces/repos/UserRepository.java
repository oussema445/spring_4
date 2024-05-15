package com.oussema.pieces.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.pieces.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
