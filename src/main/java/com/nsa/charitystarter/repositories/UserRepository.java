package com.nsa.charitystarter.repositories;

import com.nsa.charitystarter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
