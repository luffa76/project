package edu.pusan.example.dept.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tb_dept")
public class Dept {
  @Id
  private String deptCd;
  private String deptNm;
}
