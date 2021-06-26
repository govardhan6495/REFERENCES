package com.demo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User getById(Long id);
}
