package com.board.boardproject.controller;

import java.util.Map;

import com.board.boardproject.dto.paging.PageRequestDTO;
import com.board.boardproject.dto.paging.PageResponseDTO;
import com.board.boardproject.dto.reply.ReplyDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.board.boardproject.service.reply.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/replies/")
public class ReplyController {

  //custom 예외처리
  public static class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String msg){
      super(msg);
    }
  }

  //service 의존성 주입
  private final ReplyService replyService;

  //list
  //produces: 만들어내는 데이터
  @GetMapping(value = "{bno}/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public PageResponseDTO<ReplyDTO> getlist(
    @PathVariable("bno") Integer bno, PageRequestDTO pageRequestDTO
  ){
    log.info("get | replyList-----------------------------");

    return replyService.getList(bno, pageRequestDTO);
  }

  //register
  //@RequestBody: 보내는 데이터 JSON형식
  //rno 데이터 전달 위해 return타입 Map
  @PostMapping("{bno}/register")
  public Map<String, Integer> register(
    @PathVariable("bno") Integer bno, @RequestBody ReplyDTO replyDTO
  ){
    log.info("post | replyRegister-----------------------------");
    //안전장치
    replyDTO.setBno(bno);

    //rno 설정
    Integer rno = replyService.register(replyDTO);

    return Map.of("result", rno);
  }

  //read
  @GetMapping("read/{rno}")
  public ReplyDTO readOne(
    @PathVariable("rno") Integer rno
  ){
    log.info("get | replyRead-----------------------------");

    return replyService.readOne(rno);
  }

  //delete
  @DeleteMapping("delete/{rno}")
  public Map<String, Integer> delete(
    @PathVariable("rno") Integer rno
  ){
    log.info("delete | replyDelete-----------------------------");

    replyService.delete(rno);

    return Map.of("result", rno);
  }

  //modify
  @PutMapping("modify/{rno}")
  public Map<String, Integer> modify(
    @RequestBody ReplyDTO replyDTO
  ){
    log.info("modify | replyModify-----------------------------");

    replyService.modify(replyDTO);

    return Map.of("result", replyDTO.getRno());
  }
}
