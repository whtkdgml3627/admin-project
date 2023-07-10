package org.zerock.breply.util;

import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class ManegementCookie {
  private static final String COOKIE_NAME = "read_board_";

  // Board 조회수를 위한 쿠키 생성
  public boolean createCookie(HttpServletRequest request, HttpServletResponse response, Integer bno) {
    String cookieName = COOKIE_NAME + bno;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(cookieName)) {
          // 이미 쿠키가 존재하므로 조회수를 증가시키지 않습니다
          return false;
        }
      }
    }
    // 쿠키 생성
    Cookie cookie = new Cookie(cookieName, "true");
    cookie.setMaxAge(60 * 60 * 24); // 쿠키를 24시간 동안 유지
    response.addCookie(cookie);

    // 쿠키가 없으므로 조회수를 증가시키도록 true를 반환합니다
    return true;
  }
}
