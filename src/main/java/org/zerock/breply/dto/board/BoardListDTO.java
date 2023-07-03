package org.zerock.breply.dto.board;

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
  private String writer;  //작성자
  private String dueDate; //등록일
}
