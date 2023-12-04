package edu.pusan.example.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pusan.example.dept.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, String> {
  
}
