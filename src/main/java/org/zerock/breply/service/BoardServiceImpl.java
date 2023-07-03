package org.zerock.breply.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.breply.dto.board.BoardListDTO;
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
  
}
