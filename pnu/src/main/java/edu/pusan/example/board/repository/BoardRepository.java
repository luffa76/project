package edu.pusan.example.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pusan.example.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
    List<Board> findAllByUsed(String used);
}