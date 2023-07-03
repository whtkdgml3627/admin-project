package org.zerock.breply.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;

public interface BoardMapper {

  //list
  List<BoardListDTO> getList(PageRequestDTO pageRequestDTO);
  //count
  long listCount(PageRequestDTO pageRequestDTO);
  
  


  //DB연결 시간 체크
  // @Select("select now()")
  // String getTime();

}
