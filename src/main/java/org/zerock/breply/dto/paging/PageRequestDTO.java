package org.zerock.breply.dto.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {
  //변수 선언
  @Builder.Default
  private int page = 1;     //page번호
  @Builder.Default
  private int size = 10;    //size
  private String type;      //검색type
  private String keyword;   //검색어
  private String link;      //검색조건, 페이지, 사이즈 통합

  //page번호 음수값 제외처리
  public void setPage(int page){
    if(page < 0){
      this.page = 1;
    }else{
      this.page = page;
    }
  }

  //size 음수값, 과도한 값 제외처리
  public void setSize(int size){
    if(size < 0 || size > 100){
      this.size = 10;
    }else{
      this.size = size;
    }
  }

  //limit에 들어갈 skip 계산
  public int getSkip(){
    return (this.page - 1) * this.size;
  }

  //다음페이지를 위한 count
  public int getCountEnd(){
    return ((int) Math.ceil(this.page / 10.0) * (10 * this.size)) + 1;
  }

  public String getLink(){

    if(link == null){
      //문자열 합치기
      StringBuilder strBuilder = new StringBuilder();

      //page, size 쿼리스트링 전달
      strBuilder.append("page=" + this.page);
      strBuilder.append("&size=" + this.size);

      //toString으로 합친 문자열 String으로 반환
      link = strBuilder.toString();
    }

    return link;
  }

}
