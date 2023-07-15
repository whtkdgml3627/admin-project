package org.zerock.breply.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.reply.ReplyDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

  @Autowired(required = false)
  private ReplyMapper replyMapper;

  //list test
  @Test
  public void testReplyList(){
    //bno
    Integer bno = 720909;
    //list
    PageRequestDTO dto = PageRequestDTO.builder().build();
    
    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyMapper.getList(bno, dto));
  }

  //댓글 test
  //test rallback이 default
  //commit 설정
  @Test
  @Transactional
  @Commit
  public void testReplyRegister(){
    //ReplyDTO
    ReplyDTO replyDTO = ReplyDTO.builder()
      .bno(720908)
      .reply("Reply Mapper Test")
      .replyer("Replyer Mapper Test")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");

    int insertCount = replyMapper.registerReply(replyDTO);

    //예외처리
    Assertions.assertEquals(insertCount, 1);

    if(insertCount != 1){
      throw new RuntimeException("INSERT FAIL");
    }

    Integer rno = replyDTO.getRno();
    log.info("rno: " + rno);

    replyMapper.updateReplyGno(rno);
  }

  //대댓글 test
  //test rallback이 default
  //commit 설정
  @Test
  @Transactional
  @Commit
  public void testReplyRegisterChild(){
    //ReplyDTO
    ReplyDTO replyDTO = ReplyDTO.builder()
      .bno(720908)
      .reply("Reply Mapper Test")
      .replyer("Replyer Mapper Test")
      .gno(15)
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");

    int insertCount = replyMapper.registerReplyChild(replyDTO);

    //예외처리
    Assertions.assertEquals(insertCount, 1);

    if(insertCount != 1){
      throw new RuntimeException("INSERT FAIL");
    }
  }

  //read test
  @Test
  public void testReadOne(){
    Integer rno = 45;

    log.info("=====================================================================");
    log.info("=====================================================================");
    log.info(replyMapper.readOne(rno));
  }

  //delete test
  @Test
  @Transactional
  public void testReplyDelete(){
    Integer rno = 43;

    log.info("=====================================================================");
    log.info("=====================================================================");
    replyMapper.delete(rno);
  }

  //modify test
  @Test
  @Transactional
  @Commit
  public void testReplyModify(){
    ReplyDTO replyDTO = ReplyDTO.builder()
      .rno(44)
      .reply("0713 Reply Modify 20:47")
      .build();

    log.info("=====================================================================");
    log.info("=====================================================================");
    replyMapper.modify(replyDTO);
  }
  
}
