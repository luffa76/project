package edu.pusan.example.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.pusan.example.dept.domain.Dept;
import lombok.Data;

@Data
@Entity(name = "tb_user")
public class User {
  @Id
  private String userId;
  private String pwd;
  private String name;
  private String job;
  private String email;
  private String phone;

  @OneToOne
  @JoinColumn(name = "dept_cd")
  private Dept dept;
}
