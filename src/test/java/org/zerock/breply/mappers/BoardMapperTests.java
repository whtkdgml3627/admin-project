package org.zerock.breply.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.breply.dto.paging.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
  //의존성 주입
  @Autowired(required = false)
  private BoardMapper boardMapper;

  @Test
  public void testBoardGetList(){
    PageRequestDTO dto = PageRequestDTO.builder().build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(boardMapper.getList(dto));

    boardMapper.listCount(dto);

  }

  //DB연결 시간 체크
  // @Test
  // public void testGetTime(){
  //   log.info(boardMapper.getTime());
  // }

}
