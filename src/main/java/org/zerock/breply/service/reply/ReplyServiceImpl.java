package org.zerock.breply.service.reply;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.paging.PageResponseDTO;
import org.zerock.breply.dto.reply.ReplyDTO;
import org.zerock.breply.mappers.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

  //mapper 의존성 주입
  private final ReplyMapper replyMapper;
  
  //list
  @Override
  public PageResponseDTO<ReplyDTO> getList(
    Integer bno, PageRequestDTO pageRequestDTO
  ) {
    //20개씩 불러오게 사이즈 조정
    pageRequestDTO.setSize(20);

    //list
    List<ReplyDTO> list = replyMapper.getList(bno, pageRequestDTO);
    //total
    int total = replyMapper.getBnoCount(bno);

    return PageResponseDTO.<ReplyDTO>withAll()
      .list(list)
      .total(total)
      .pageRequestDTO(pageRequestDTO)
      .build();
  }

  //register
  //댓글, 대댓글
  @Override
  public Integer register(ReplyDTO replyDTO) {
    Integer result = null;
    Integer gno = replyDTO.getGno();

    //댓글일 때
    if(gno == 0){
      //정상 등록 확인을 위한 count
      //댓글이므로 registerReply
      int count = replyMapper.registerReply(replyDTO);
      
      //정상 등록 아닐 시 예외처리
      if(count != 1){
        throw new RuntimeException("Reply Insert Exception");
      }

      //rno값을 가져온 뒤 update
      Integer rno = replyDTO.getRno();
      replyMapper.updateReplyGno(rno);
      result = rno;
    }else{
      //대댓글일때
      int count = replyMapper.registerReplyChild(replyDTO);
      
      //정상 등록 아닐 시 예외처리
      if(count != 1){
        throw new RuntimeException("Reply Insert Exception");
      }

      result = replyDTO.getRno();
    }
    return result;
  }
  
}
