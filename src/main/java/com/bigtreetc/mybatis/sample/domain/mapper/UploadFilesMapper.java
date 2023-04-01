package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.UploadFiles;
import com.bigtreetc.mybatis.sample.domain.model.UploadFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UploadFilesMapper {
  long countByExample(UploadFilesExample example);

  int deleteByExample(UploadFilesExample example);

  int deleteByPrimaryKey(Long uploadFileId);

  int insert(UploadFiles record);

  int insertSelective(UploadFiles record);

  List<UploadFiles> selectByExampleWithBLOBsWithRowbounds(
      UploadFilesExample example, RowBounds rowBounds);

  List<UploadFiles> selectByExampleWithBLOBs(UploadFilesExample example);

  List<UploadFiles> selectByExampleWithRowbounds(UploadFilesExample example, RowBounds rowBounds);

  List<UploadFiles> selectByExample(UploadFilesExample example);

  UploadFiles selectByPrimaryKey(Long uploadFileId);

  int updateByExampleSelective(
      @Param("record") UploadFiles record, @Param("example") UploadFilesExample example);

  int updateByExampleWithBLOBs(
      @Param("record") UploadFiles record, @Param("example") UploadFilesExample example);

  int updateByExample(
      @Param("record") UploadFiles record, @Param("example") UploadFilesExample example);

  int updateByPrimaryKeySelective(UploadFiles record);

  int updateByPrimaryKeyWithBLOBs(UploadFiles record);

  int updateByPrimaryKey(UploadFiles record);

  int upsert(UploadFiles record);

  int upsertSelective(UploadFiles record);

  int upsertWithBLOBs(UploadFiles record);
}
