package org.zerock.breply.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.breply.dto.paging.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  
  //의존성 주입
  @Autowired
  private BoardService boardService;

  //list
  @Test
  public void testBoardGetList(){
    
    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardService.getList(PageRequestDTO.builder().build()));

  }

}
