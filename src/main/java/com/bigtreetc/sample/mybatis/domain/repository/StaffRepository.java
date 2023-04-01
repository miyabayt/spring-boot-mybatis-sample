package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.Staff;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffRepository {
  Staff findById(Long pk1);

  Optional<Staff> findOne(StaffExample example);

  Page<Staff> findAll(StaffExample example, Pageable pageable);

  Cursor<Staff> findAll(StaffExample example);

  int create(Staff staff);

  int createAll(List<Staff> list);

  int update(Staff staff);

  int delete(Long pk1);
}
