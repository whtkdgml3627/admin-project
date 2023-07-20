package com.board.boardproject.service.reply;

import com.board.boardproject.dto.paging.PageRequestDTO;
import com.board.boardproject.dto.paging.PageResponseDTO;
import com.board.boardproject.dto.reply.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReplyService {

  //list
  PageResponseDTO<ReplyDTO> getList(Integer bno, PageRequestDTO pageRequestDTO);

  //register
  Integer register(ReplyDTO replyDTO);

  //read
  ReplyDTO readOne(Integer rno);

  //delete
  void delete(Integer rno);

  //modify
  void modify(ReplyDTO replyDTO);
  
}
