package edu.pusan.example.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pusan.example.dept.service.DeptService;
import edu.pusan.example.user.domain.User;
import edu.pusan.example.user.domain.dto.UserDto;
import edu.pusan.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;
  private final DeptService deptService;

  public void insertUser(UserDto userDto) {
    User user = userDto.build();
    user.setDept(deptService.getDeptInfo(userDto.getDeptCd()));
    userRepository.save(user);
  }

  public UserDto getUserInfo(UserDto userDto) {
    User user = userRepository.findById(userDto.getUserId()).get();

    return UserDto.builder()
      .userId(user.getUserId())
      .email(user.getEmail())
      .job(user.getJob())
      .name(user.getName())
      .phone(user.getPhone())
      .deptNm(user.getDept().getDeptNm())
      .deptCd(user.getDept().getDeptCd())
      .build();
  }


  public Boolean checkUser(UserDto userDto) {
    Optional<User> user = userRepository.findById(userDto.getUserId());

    if(user.isPresent()) {
      if(user.get().getPwd().equals(userDto.getPwd())) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public void updatetUser(UserDto userDto) {
    User user = userDto.build();
    user.setDept(deptService.getDeptInfo(userDto.getDeptCd()));
    userRepository.save(user);
  }

  public void deleteUser(String userId) {
    userRepository.deleteById(userId);
  }

}
