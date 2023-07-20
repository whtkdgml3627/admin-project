package com.board.boardproject.dto.board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRegisterDTO {
  //변수
  private Integer bno;    //pk
  private String title;   //제목
  private String content; //내용
  private String writer;  //작성자

  private List<String> fileNames; //파일업로드 파일명저장
}
