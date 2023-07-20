package com.board.boardproject.mappers;

import java.util.List;

import com.board.boardproject.dto.board.BoardDTO;
import com.board.boardproject.dto.board.BoardListDTO;
import com.board.boardproject.dto.board.BoardRegisterDTO;
import com.board.boardproject.dto.paging.PageRequestDTO;

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
