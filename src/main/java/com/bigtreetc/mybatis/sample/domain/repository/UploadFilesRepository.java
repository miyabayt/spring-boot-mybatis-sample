package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.UploadFiles;
import com.bigtreetc.mybatis.sample.domain.model.generated.UploadFilesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UploadFilesRepository {
  Page<UploadFiles> findAll(UploadFilesExample example, Pageable pageable);
}
