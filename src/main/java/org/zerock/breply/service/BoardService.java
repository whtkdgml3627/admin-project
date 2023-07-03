package org.zerock.breply.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;

@Transactional
public interface BoardService {
  
  //list
  PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO);

}
