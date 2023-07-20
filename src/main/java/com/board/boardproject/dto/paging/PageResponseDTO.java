package com.board.boardproject.dto.paging;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO<E> {
  //변수
  private List<E> list; //리스트 출력해줄 List
  private long total;    //PageRequestDTO에서 getCountEnd를 담을 변수
  //페이징 계산 변수
  private int page;         //페이지 번호
  private int size;         //페이지 사이즈
  private int startNum;     //시작 페이지 번호
  private int endNum;       //끝 페이지 번호
  private boolean prevBtn;  //이전 버튼 유무
  private boolean nextBtn;  //다음 버튼 유무
  private boolean replyLast;//댓글 마지막 페이징 유무

  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(
    List<E> list, long total, PageRequestDTO pageRequestDTO
  ){
    this.list = list;
    this.total = total;
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();
    this.replyLast = pageRequestDTO.isReplyLast();

    //페이징 계산
    //시작 페이지 번호 계산
    this.startNum = ((int) (Math.ceil(this.page / 10.0) * 10) - 9);
    //끝 페이지 번호 계산
    this.endNum = this.startNum + 9;
    //끝 페이지가 last보다 크면 last로 끝페이지 수정
    int last = (int)(Math.ceil((total/(double)size)));
    this.endNum = endNum > last ? last : endNum;
    //시작페이지가 1보다 클 때만 이전버튼
    this.prevBtn = this.startNum > 1;
    //total이 끝 페이지 번호와 size를 곱한 값보다 크면 다음버튼
    this.nextBtn = total > this.endNum * this.size;
  }

}
