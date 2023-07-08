package org.zerock.breply.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;

@Transactional
public interface BoardService {
  
  //list
  PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO);

  //register
  void register(BoardRegisterDTO registerDTO);

  //read
  BoardDTO getOne(Integer bno);

  //delete
  void delete(Integer bno);

  //modify
  void modify(BoardDTO boardDTO);

}
