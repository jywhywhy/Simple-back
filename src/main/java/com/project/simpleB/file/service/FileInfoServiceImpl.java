package com.project.simpleB.file.service;

import com.project.simpleB.file.dto.FileInfoDTO;
import com.project.simpleB.file.entity.FileInfo;
import com.project.simpleB.file.mapper.FileInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileInfoServiceImpl implements FileInfoService{

    private final FileInfoMapper fileInfoMapper;

    @Override
    public void saveFile(Long bId, List<FileInfoDTO> fileList) {
        for (FileInfoDTO file : fileList) {
            fileInfoMapper.save(FileInfo.builder()
                    .bId(bId)
                    .saveName(file.getSaveName())
                    .originalName(file.getOriginalName())
                    .build());
        }
    }

    @Override
    public List<FileInfo> getFileInfo(Long bId) {
        return fileInfoMapper.getFileInfo(bId);
    }

    @Override
    public void delete(List<FileInfo> list) {
        for (FileInfo file : list) {
            fileInfoMapper.delete(file.getFId());
        }
    }
}
