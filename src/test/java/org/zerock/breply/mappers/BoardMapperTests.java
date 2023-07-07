package org.zerock.breply.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
  //의존성 주입
  @Autowired(required = false)
  private BoardMapper boardMapper;

  //list test
  @Test
  public void testBoardGetList(){
    PageRequestDTO dto = PageRequestDTO.builder().build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardMapper.getList(dto));

    boardMapper.listCount(dto);

  }
  
  //register test
  @Test
  public void testBoardRegister(){
    BoardRegisterDTO registerDTO = BoardRegisterDTO.builder()
      .title("Mapper Test Title1")
      .content("Mapper Test Content1")
      .writer("Mapper test writer1")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    boardMapper.register(registerDTO);

  }
  
  //read test
  @Test
  public void testBoardGetOne(){

    Integer bno = 720906;

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardMapper.getOne(bno));
  }
  
  //delete test
  @Test
  public void testBoardDelete(){

    Integer bno = 720906;

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardMapper.delete(bno));
  }

  //DB연결 시간 체크
  // @Test
  // public void testGetTime(){
  //   log.info(boardMapper.getTime());
  // }

}
