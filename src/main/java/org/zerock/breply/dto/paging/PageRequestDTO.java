package org.zerock.breply.dto.paging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
 * 페이지 번호와 페이지 사이즈를 구하는 DTO
 * 어노테이션은 get만 설정
 * 페이지 번호 page
 * 페이지 사이즈 size
 * set 메소드 설정
 * - page (음수 페이지 설정시 1페이지로 고정)
 * - size (음수로 불러오거나 100 이상 설정 시 10으로 고정)
 * limit 에 들어갈 skip 계산
 * - page - 1 * size
 * 다음페이지를 위한 count 구하기
 * - page / 10.0(ceil로 올림처리) * 10*size
 * getLink로 쿼리스트링 처리
 */

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
  private boolean replyLast;     //댓글 페이징 마지막 페이지 유무

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

  //type 배열로 반환 처리
  public String[] getTypes(){
    if(this.type == null || this.type.isEmpty()){
      return null;
    }
    return this.type.split("");
  }

  public String getLink(){

    if(link == null){
      //문자열 합치기
      StringBuilder strBuilder = new StringBuilder();

      //page, size 쿼리스트링 전달
      strBuilder.append("page=" + this.page);
      strBuilder.append("&size=" + this.size);

      //검색타입
      if(type != null && type.length() > 0){
        strBuilder.append("&type=" + this.type);
      }

      //검색어
      if(keyword != null && keyword.length() > 0){
        try {
          strBuilder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }

      //toString으로 합친 문자열 String으로 반환
      link = strBuilder.toString();
    }

    return link;
  }

}
