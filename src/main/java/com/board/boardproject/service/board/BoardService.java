package com.board.boardproject.service.board;

import com.board.boardproject.dto.board.BoardDTO;
import com.board.boardproject.dto.board.BoardListDTO;
import com.board.boardproject.dto.board.BoardRegisterDTO;
import com.board.boardproject.dto.paging.PageRequestDTO;
import com.board.boardproject.dto.paging.PageResponseDTO;
import org.springframework.transaction.annotation.Transactional;

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

  //viewCount
  void viewCount(Integer bno);

}
