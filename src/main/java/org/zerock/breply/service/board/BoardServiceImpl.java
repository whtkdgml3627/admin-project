package org.zerock.breply.service.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;
import org.zerock.breply.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  //mapper 의존성 주입
  private final BoardMapper boardMapper;
  
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
    //등록만 전달
    boardMapper.register(registerDTO);
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
