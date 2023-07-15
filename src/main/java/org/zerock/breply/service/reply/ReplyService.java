package org.zerock.breply.service.reply;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;
import org.zerock.breply.dto.reply.ReplyDTO;

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
