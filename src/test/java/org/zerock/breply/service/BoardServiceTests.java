package org.zerock.breply.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.service.board.BoardService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  
  //의존성 주입
  @Autowired
  private BoardService boardService;

  //list test
  @Test
  public void testBoardGetList(){
    
    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardService.getList(PageRequestDTO.builder().build()));

  }

  //register test
  @Test
  public void testBoardRegister(){
    BoardRegisterDTO registerDTO = BoardRegisterDTO.builder()
      .title("Service Test")
      .content("Service Test Content")
      .writer("Service Writer")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    boardService.register(registerDTO);
  }

  //read test
  @Test
  public void testBoardGetOne(){
    Integer bno = 720905;
    
    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardService.getOne(bno));
  }

  //delete test
  @Test
  public void testBoardDelete(){
    Integer bno = 720905;

    log.info("=====================================================================");
    log.info("=====================================================================");
    boardService.delete(bno);
  }

  //modify test
  @Test
  public void testBoardModify(){
    BoardDTO boardDTO = BoardDTO.builder()
      .bno(720907)
      .title("Service Modify Title")
      .content("Service Modify Content")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    boardService.modify(boardDTO);
  }

}
