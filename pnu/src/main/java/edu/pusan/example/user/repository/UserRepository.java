package edu.pusan.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pusan.example.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
  
}
