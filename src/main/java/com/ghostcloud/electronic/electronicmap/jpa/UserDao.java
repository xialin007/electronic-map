package com.ghostcloud.electronic.electronicmap.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghostcloud.electronic.electronicmap.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
}