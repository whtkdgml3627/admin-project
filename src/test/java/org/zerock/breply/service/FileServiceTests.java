package org.zerock.breply.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.mappers.FileMapper;
import org.zerock.breply.service.board.BoardService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootTest
@Log4j2
public class FileServiceTests {

  //의존성 주입 board
  @Autowired(required = false)
  private BoardService boardService;

  //의존성 주입 file
  @Autowired(required = false)
  private FileMapper fileMapper;

  @Test
  @Transactional
  @Commit
  public void testBoardFileUpload(){
    //등록
    BoardRegisterDTO registerDTO = BoardRegisterDTO.builder()
      .title("File Service Test Title1")
      .content("File Service Test Content1")
      .writer("File Service test writer1")
      .fileNames(List.of(UUID.randomUUID() + "_f1.jpg", UUID.randomUUID() + "_f2.jpg"))
      .build();

    //게시판 등록
    boardService.register(registerDTO);

  }

}
