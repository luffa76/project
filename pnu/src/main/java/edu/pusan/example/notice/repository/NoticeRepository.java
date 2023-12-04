package edu.pusan.example.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pusan.example.notice.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
    
}
