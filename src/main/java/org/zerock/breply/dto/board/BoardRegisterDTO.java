package org.zerock.breply.dto.board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRegisterDTO {
  //변수
  private String title;   //제목
  private String content; //내용
  private String writer;  //작성자
}
