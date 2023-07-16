package org.zerock.breply.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.board.BoardRegisterDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootTest
@Log4j2
public class FileMapperTests {

  //의존성 주입 file
  @Autowired(required = false)
  private FileMapper fileMapper;

  //의존성 주입 board
  @Autowired(required = false)
  private BoardMapper boardMapper;



  @Test
  @Transactional
  @Commit
  public void testFileUpload(){
    //등록
    BoardRegisterDTO registerDTO = BoardRegisterDTO.builder()
      .title("File Mapper Test Title1")
      .content("File Mapper Test Content1")
      .writer("File Mapper test writer1")
      .fileNames(List.of(UUID.randomUUID() + "_f1.jpg", UUID.randomUUID() + "_f2.jpg"))
      .build();

    //파일이름 List로 가져오기
    List<String> fileNames = registerDTO.getFileNames();

    //게시판 등록
    int count = boardMapper.register(registerDTO);
    log.info("insert product count: " + count);

    //게시판 등록 성공과 파일이 등록되었다면 실행
    if(count > 0 && registerDTO.getFileNames() != null && !registerDTO.getFileNames().isEmpty()){
      //bno 가져오기
      Integer bno = registerDTO.getBno();
      log.info("--------------------------------- bno: " + bno);

      AtomicInteger index = new AtomicInteger();

      //등록된 파일 fileNames에서 추출
      List<Map<String, String>> list = fileNames.stream().map(str -> {
        //uuid 가져오기
        String uuid = str.substring(0, 36);
        //실제 파일명 가져오기
        String fileName = str.substring(37);
        
        //return map에 담기
        return Map.of("uuid", uuid, "file_name", fileName, "bno", "" + bno, "ord", "" + index.getAndIncrement());
      }).collect(Collectors.toList());

      log.info("=====================================================================");
      log.info("=====================================================================");
      log.info(list);

      //파일 등록 실행
      fileMapper.registerImage(list);
    }
  }

}
