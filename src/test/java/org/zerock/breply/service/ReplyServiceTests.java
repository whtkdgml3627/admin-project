package org.zerock.breply.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.reply.ReplyDTO;
import org.zerock.breply.service.reply.ReplyService;

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
  
}
