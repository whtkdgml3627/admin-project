package org.zerock.breply.mappers;

import java.util.List;
import java.util.Map;

public interface FileMapper {

  //file register
  int registerImage(List<Map<String, String>> imageList);

}
