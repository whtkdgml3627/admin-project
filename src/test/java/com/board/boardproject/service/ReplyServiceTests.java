package com.board.boardproject.service;

import com.board.boardproject.dto.paging.PageRequestDTO;
import com.board.boardproject.dto.reply.ReplyDTO;
import com.board.boardproject.service.reply.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {

  @Autowired
  private ReplyService replyService;

  //list test
  @Test
  public void testGetList(){
    //bno
    Integer bno = 720909;
    //list
    PageRequestDTO dto = PageRequestDTO.builder().build();
    
    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyService.getList(bno, dto));
  }

  //register test 댓글
  @Test
  public void testRegisterReply(){
    ReplyDTO replyDTO = ReplyDTO.builder()
      .bno(720909)
      .reply("Reply Service Test")
      .replyer("Reply Service Replyer")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyService.register(replyDTO));
  }

  //register test 대댓글
  @Test
  public void testRegisterReplyChild(){
    ReplyDTO replyDTO = ReplyDTO.builder()
      .bno(720909)
      .gno(17)
      .reply("Reply Child Service Test")
      .replyer("Reply Child Service Replyer")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyService.register(replyDTO));
  }

  //read test
  @Test
  public void testReadOne(){
    Integer rno = 45;

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyService.readOne(rno));
  }

  //delete test
  @Test
  public void testReplyDelete(){
    Integer rno = 44;

    log.info("=====================================================================");
    log.info("=====================================================================");
    replyService.delete(rno);
  }

  //modify test
  @Test
  public void testReplyModify(){
    ReplyDTO replyDTO = ReplyDTO.builder()
      .rno(45)
      .reply("Reply Service Modify 0715")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    replyService.modify(replyDTO);
  }
  
}
