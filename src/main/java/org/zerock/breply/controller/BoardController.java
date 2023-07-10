package org.zerock.breply.controller;

/*
 * page물고가야 하는 곳은 PageRequestDTO 파라미터 설정
 * read, modify
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;
import org.zerock.breply.service.board.BoardService;
import org.zerock.breply.util.ManegementCookie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Log4j2
public class BoardController {
  
  //서비스 선언 의존성 주입
  private final BoardService boardService;
  private final ManegementCookie manegementCookie;

  //list
  @GetMapping("/list")
  public void list(
    PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | list..........................");
    PageResponseDTO<BoardListDTO> list = boardService.getList(pageRequestDTO);

    model.addAttribute("boardList", list);
  }

  //register
  @GetMapping("/register")
  public void getRegister(){
    log.info("get | register..........................");
  }

  @PostMapping("/register")
  public String postRegister(
    BoardRegisterDTO registerDTO, RedirectAttributes rttr
  ){
    log.info("post | register..........................");
    //service
    boardService.register(registerDTO);

    //redirect 메세지
    rttr.addFlashAttribute("message", "게시물이 등록 되었습니다.");

    return "redirect:/board/list";
  }
  // /register

  //read
  @GetMapping("/read/{bno}")
  public String getRead(
    PageRequestDTO pageRequestDTO, @PathVariable("bno") Integer bno, HttpServletRequest request, HttpServletResponse response, Model model
  ){
    log.info("get | read..........................");
    if(manegementCookie.createCookie(request, response, bno)){
      boardService.viewCount(bno);
      log.info("Cookie Check");
    }
    //DTO 로 선언
    BoardDTO boardDTO = boardService.getOne(bno);

    //model로 화면 출력
    model.addAttribute("read", boardDTO);

    return "/board/read";
  }

  //delete
  @PostMapping("/delete/{bno}")
  public String postDelete(
    @PathVariable("bno") Integer bno, RedirectAttributes rttr
  ){
    log.info("post | delete..........................");
    //service 삭제 호출
    boardService.delete(bno);

    //list로 메세지 전달
    rttr.addFlashAttribute("message", bno + " 게시물이 삭제 되었습니다.");
    return "redirect:/board/list";
  }

  //modify
  @GetMapping("/modify/{bno}")
  public String getModify(
    PageRequestDTO pageRequestDTO, @PathVariable("bno") Integer bno, Model model
  ){
    log.info("get | modify..........................");
    //DTO 로 선언
    BoardDTO boardDTO = boardService.getOne(bno);

    //model로 화면 출력
    model.addAttribute("modify", boardDTO);

    return "/board/modify";
  }

  @PostMapping("/modify/{bno}")
  public String postModify(
    BoardDTO boardDTO, RedirectAttributes rttr
  ){
    log.info("post | modify..........................");

    boardService.modify(boardDTO);
    rttr.addFlashAttribute("message", boardDTO.getBno() + " 게시물이 수정 되었습니다.");

    return "redirect:/board/read/" + boardDTO.getBno();
  }

  // /modify

}
