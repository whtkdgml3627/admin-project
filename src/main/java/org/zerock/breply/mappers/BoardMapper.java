package org.zerock.breply.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.zerock.breply.dto.board.BoardDTO;
import org.zerock.breply.dto.board.BoardListDTO;
import org.zerock.breply.dto.board.BoardRegisterDTO;
import org.zerock.breply.dto.paging.PageRequestDTO;

public interface BoardMapper {

  //board list
  List<BoardListDTO> getList(PageRequestDTO pageRequestDTO);
  //board count
  long listCount(PageRequestDTO pageRequestDTO);

  //board register
  int register(BoardRegisterDTO boardRegisterDTO);

  //board read
  BoardDTO getOne(Integer bno);

  //board delete
  int delete(Integer bno);

  //board modify
  int modify(BoardDTO boardDTO);

  //board viewcnt
  int viewCount(Integer bno);

  //DB연결 시간 체크
  // @Select("select now()")
  // String getTime();

}
