package org.zerock.breply.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.breply.dto.paging.PageRequestDTO;
import org.zerock.breply.dto.reply.ReplyDTO;

public interface ReplyMapper {
  
  //list
  List<ReplyDTO> getList(
    @Param("bno") Integer bno, @Param("pr") PageRequestDTO pageRequestDTO
  );
  //total
  int getBnoCount(Integer bno);

  /* gno가 0일 때 실행하는 영역 */
  //register 댓글
  int registerReply(ReplyDTO replyDTO);

  // 댓글의 gno 업데이트
  int updateReplyGno(Integer rno);
  /* //gno가 0일 때 실행하는 영역 */

  /* gno가 0이 아닐 때 실행하는 영역 */
  //register 대댓글
  int registerReplyChild(ReplyDTO replyDTO);
  /* //gno가 0이 아닐 때 실행하는 영역 */

  //delete
  int delete(Integer rno);

  //modify
  int modify(ReplyDTO replyDTO);

}
