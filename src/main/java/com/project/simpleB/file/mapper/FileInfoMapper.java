package com.project.simpleB.file.mapper;

import com.project.simpleB.file.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileInfoMapper {

    void save(FileInfo build);

    List<FileInfo> getFileInfo(Long bId);

    void delete(Long fId);
}
