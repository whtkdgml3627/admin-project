package com.board.boardproject.service.board;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.board.boardproject.dto.board.BoardDTO;
import com.board.boardproject.dto.board.BoardListDTO;
import com.board.boardproject.dto.board.BoardRegisterDTO;
import com.board.boardproject.dto.paging.PageRequestDTO;
import com.board.boardproject.dto.paging.PageResponseDTO;
import com.board.boardproject.mappers.FileMapper;
import org.springframework.stereotype.Service;
import com.board.boardproject.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  //mapper 의존성 주입
  private final BoardMapper boardMapper;
  private final FileMapper fileMapper;
  
  //list
  @Override
  public PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO) {
    //list
    List<BoardListDTO> list = boardMapper.getList(pageRequestDTO);
    //total
    long total = boardMapper.listCount(pageRequestDTO);
    
    return PageResponseDTO.<BoardListDTO>withAll()
      .list(list)
      .total(total)
      .pageRequestDTO(pageRequestDTO)
      .build();
  }

  //register
  @Override
  public void register(BoardRegisterDTO registerDTO) {
    //게시판 등록
    int count = boardMapper.register(registerDTO);
    log.info("insert product count: " + count);

    //파일이름 List로 가져오기
    List<String> fileNames = registerDTO.getFileNames();

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

  //read
  @Override
  public BoardDTO getOne(Integer bno) {
    //조회만 전달
    return boardMapper.getOne(bno);
  }

  //delete
  @Override
  public void delete(Integer bno) {
    //삭제 업데이트
    boardMapper.delete(bno);
  }

  //modify
  @Override
  public void modify(BoardDTO boardDTO) {
    //수정 업데이트
    boardMapper.modify(boardDTO);
  }

  //조회수 업데이트
  @Override
  public void viewCount(Integer bno) {
    boardMapper.viewCount(bno);
  }
  
}
