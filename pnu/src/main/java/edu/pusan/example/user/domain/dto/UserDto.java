package edu.pusan.example.user.domain.dto;

import edu.pusan.example.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
  private String userId;
  private String pwd;
  private String name;
  private String deptCd;
  private String deptNm;
  private String job;
  private String email;
  private String phone;

  public User build() {
    User user = new User();
    user.setUserId(userId);
    user.setPwd(pwd);
    user.setEmail(email);
    user.setJob(job);
    user.setName(name);
    user.setPhone(phone);
    return user;
  }
}