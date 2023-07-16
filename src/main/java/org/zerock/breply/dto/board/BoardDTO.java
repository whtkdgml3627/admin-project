package org.zerock.breply.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
  //변수
  private Integer bno;        //pk
  private String title;       //제목
  private String content;     //내용
  private String writer;      //작성자
  private String dueDate;     //등록일
  private String updateDate;  //수정일
  private boolean status;     //상태여부
  
  private List<String> fileNames; //파일업로드 파일명저장
  
}
