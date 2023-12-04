package edu.pusan.example.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pusan.example.board.domain.Board;
import edu.pusan.example.board.domain.dto.BoardDto;
import edu.pusan.example.board.repository.BoardRepository;
import edu.pusan.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    
    public List<BoardDto> getBoardList() {
        List<Board> boardList = boardRepository.findAllByUsed("Y");
        ArrayList<BoardDto> result = new ArrayList<BoardDto>();
        
        for (Board board : boardList) {
            BoardDto temp = BoardDto.builder()
                                .boardId(board.getBoardId())
                                .title(board.getTitle())
                                .contents(board.getContents())
                                .insertDate(board.getInsertDate())
                                .used(board.getUsed())
                                .writerId(board.getWriter().getUserId())
                                .writerName(board.getWriter().getName())
                                .build();
            result.add(temp);
        }

        return result;
    }

    public void insertBoard(BoardDto boardDto) {
        Board board = boardDto.build();
        board.setUsed("Y");
        board.setWriter(userRepository.findById(boardDto.getWriterId()).get());
        boardRepository.save(board);
    }

    public BoardDto getBoard(int boardId) {
        Board board = boardRepository.findById(boardId).get();

        BoardDto boardDto = BoardDto.builder()
                                .boardId(board.getBoardId())
                                .title(board.getTitle())
                                .contents(board.getContents())
                                .insertDate(board.getInsertDate())
                                .updateDate(board.getUpdateDate())
                                .used(board.getUsed())
                                .writerId(board.getWriter().getUserId())
                                .writerName(board.getWriter().getName())
                                .build();

        return boardDto;
    }

    public void updateBoard(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getBoardId()).get();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        
        boardRepository.save(board);
    }

    public void deleteBoard(int boardId) {
        Board board = boardRepository.findById(boardId).get();
        board.setUsed("N");
        
        boardRepository.save(board);
    }
}
