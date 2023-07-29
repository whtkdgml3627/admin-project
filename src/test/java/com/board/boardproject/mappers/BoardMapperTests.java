package com.board.boardproject.mappers;

import com.board.boardproject.dto.paging.PageRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.board.boardproject.dto.board.BoardDTO;
import com.board.boardproject.dto.board.BoardRegisterDTO;

import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
  //의존성 주입
  @Autowired(required = false)
  private BoardMapper boardMapper;

  //TEST Builder init 내용
  private static final String TEST_TITLE = "JUnit Mapper Test Title";
  private static final String TEST_CONTENT = "JUnit Mapper Test Content";
  private static final String TEST_WRITER = "JUnit Mapper Test Writer";
  private static final Integer TEST_BNO = 720917;

  //BeforeEach 사용을 위한 DTO 정의
  private BoardRegisterDTO boardRegisterDTO;
  private BoardDTO boardDTO;

  @BeforeEach
  public void init(){
    boardRegisterDTO = BoardRegisterDTO.builder()
      .title(TEST_TITLE)
      .content(TEST_CONTENT)
      .writer(TEST_WRITER)
      .build();

    boardDTO = BoardDTO.builder()
      .bno(TEST_BNO)
      .title(TEST_TITLE)
      .content(TEST_CONTENT)
      .build();
  }

  //list test
  @Test
  @Transactional
  @DisplayName("PageRequest로 10개씩 1페이지를 불러오는 게시판 리스트")
  public void testBoardGetList(){
    //given
    PageRequestDTO dto = PageRequestDTO.builder().build();

    //when + then
    log.info("=====================================================================");
    log.info("=====================================================================");
    //list 가져오기
    log.info(boardMapper.getList(dto));
    //다음페이지를 위한 total 가져오기
    boardMapper.listCount(dto);
  }
  
  //register test
  @Test
  @Transactional
  @DisplayName("게시판 등록하기")
  public void testBoardRegister(){
    //given + when
    int insertCount = boardMapper.register(boardRegisterDTO);
    log.info("=====================================================================");
    log.info("=====================================================================");

    //then
    Assertions.assertEquals(1, insertCount, "board insert test fail");
  }
  
  //read test
  @Test
  @Transactional
  @DisplayName("게시판 상세 불러오기")
  public void testBoardGetOne(){
    //given + when
    log.info("=====================================================================");
    log.info("=====================================================================");
    BoardDTO dto = boardMapper.getOne(TEST_BNO);

    //then
    Assertions.assertNotNull(dto, "boardDTO is Null");
  }
  
  //delete test
  @Test
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  @DisplayName("게시판 삭제 (상태값을 변경하여 업데이트처리)")
  public void testBoardDelete(){
    //given = when
    log.info("=====================================================================");
    log.info("=====================================================================");
    boardMapper.delete(TEST_BNO);

    //then
    BoardDTO dto = boardMapper.getOne(TEST_BNO);
    Assertions.assertNotNull(dto, "boardDTO Delete Fail");
  }

  //modify test
  @Test
  @Transactional
  @DisplayName("게시판 수정")
  public void testBoardMOdify(){
    //given + when
    log.info("=====================================================================");
    log.info("=====================================================================");
    boardMapper.modify(boardDTO);

    //then
    BoardDTO dto = boardMapper.getOne(TEST_BNO);
    Assertions.assertNotNull(dto, "boardDTO Update Fail");

  }

  //DB연결 시간 체크
  // @Test
  // public void testGetTime(){
  //   log.info(boardMapper.getTime());
  // }

}
