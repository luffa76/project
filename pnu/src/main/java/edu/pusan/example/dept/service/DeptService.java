package edu.pusan.example.dept.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pusan.example.dept.domain.Dept;
import edu.pusan.example.dept.repository.DeptRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptService {
  private final DeptRepository deptRepository;

  public List<Dept> getDepts() {
    return deptRepository.findAll();
  }

  public Dept getDeptInfo(String deptCd) {
    return deptRepository.findById(deptCd).get();
  }
}
