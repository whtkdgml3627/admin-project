package com.board.boardproject.dto.board;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardListDTO {
  //변수
  private Integer bno;    //pk
  private String title;   //제목
  private String content; //내용
  private String writer;  //작성자
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime dueDate; //등록일
  private int replycnt;   //댓글수
  private int viewcnt;    //조회수
  private String fileName;  //파일명
}
