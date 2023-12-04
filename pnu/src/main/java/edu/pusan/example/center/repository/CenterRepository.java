package edu.pusan.example.center.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pusan.example.center.domain.Center;

public interface CenterRepository extends JpaRepository<Center, Integer> {
    
    List<Center> findAllByUsed(String used);
    
}
