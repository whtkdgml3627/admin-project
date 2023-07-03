package org.zerock.breply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;
import org.zerock.breply.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Log4j2
public class BoardController {
  
  //서비스 선언 의존성 주입
  private final BoardService boardService;

  //list
  @GetMapping("/list")
  public void list(
    PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | list..........................");
    PageResponseDTO<BoardListDTO> list = boardService.getList(pageRequestDTO);

    model.addAttribute("boardList", list);
  }


}
