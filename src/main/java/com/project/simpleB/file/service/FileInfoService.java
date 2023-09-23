package com.project.simpleB.file.service;

import com.project.simpleB.file.dto.FileInfoDTO;
import com.project.simpleB.file.entity.FileInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileInfoService {
    void saveFile(Long bId, List<FileInfoDTO> fileList);

    List<FileInfo> getFileInfo(Long bId);

    void delete(List<FileInfo> list);
}
