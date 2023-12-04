package edu.pusan.example.board.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pusan.example.board.domain.dto.BoardDto;
import edu.pusan.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
  private final BoardService boardService;

 @GetMapping("/boardListPage")
  public String boardListPage(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "boardList";
  } 

  @GetMapping("/boardInsertPage")
  public String boardInsertPage() {
    return "boardInsert";
  }

  @GetMapping("/boardInfoPage/{boardId}")
  public String boardInfoPage(@PathVariable("boardId") int boardId, Model model) {
    model.addAttribute("board", boardService.getBoard(boardId));
    return "boardInfo";
  }

  @PostMapping("/boardUpdatePage")
  public String boardUpdatePage(int boardId, Model model) {
    model.addAttribute("board", boardService.getBoard(boardId));
    return "boardUpdate";
  }

  @PostMapping("/boardInsert")
  public String boardInsert(BoardDto boardDto) {
    boardService.insertBoard(boardDto);
    return "redirect:/boardListPage";
  }

  @PostMapping("/boardUpdate")
  public String boardUpdate(BoardDto boardDto) {
    boardService.updateBoard(boardDto);
    return "redirect:/boardListPage";
  }

  @PostMapping("/boardDelete")
  public String boardDelete(int boardId) {
    boardService.deleteBoard(boardId);
    return "redirect:/boardListPage";
  }

}

