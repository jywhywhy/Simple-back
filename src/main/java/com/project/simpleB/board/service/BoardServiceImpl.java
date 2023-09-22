package com.project.simpleB.board.service;

import com.project.simpleB.board.dto.BoardDTO;
import com.project.simpleB.board.entity.Board;
import com.project.simpleB.board.mapper.BoardMapper;
import com.project.simpleB.file.dto.FileInfoDTO;
import com.project.simpleB.file.entity.FileInfo;
import com.project.simpleB.file.service.FileInfoService;
import com.project.simpleB.paging.Paging;
import com.project.simpleB.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    private final FileInfoService fileInfoService;

    @Override
    @Transactional
    public void write(BoardDTO boardDTO) {
        Board board = Board.builder()
                .mId(boardDTO.getMId())
                .bTitle(boardDTO.getBTitle())
                .bContent(boardDTO.getBContent())
                .build();

        boardMapper.write(board);

        if (!CollectionUtils.isEmpty(boardDTO.getFiles())) {
            try {
                List<FileInfoDTO> fileList = FileUtil.uploadFiles(boardDTO.getFiles());
                fileInfoService.saveFile(board.getBId(), fileList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Paging list(int pageIndex) {
        Paging paging = new Paging(pageIndex, 5);
        List<Board> list = boardMapper.list(paging);
        int totalCount = boardMapper.count();

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        paging.pagingList(list.stream()
                .map(board -> BoardDTO.builder()
                        .bId(board.getBId())
                        .mId(board.getMId())
                        .bTitle(board.getBTitle())
                        .bContent(board.getBContent())
                        .bCreateDate(board.getBCreateDate())
                        .bViews(board.getBViews())
                        .build())
                .collect(Collectors.toList()), totalCount);

        return paging;
    }

    @Override
    public BoardDTO detail(Long bId) {
        Board board = boardMapper.detail(bId);

        if (board == null) {
            return null;
        }

        return BoardDTO.builder()
                .bId(board.getBId())
                .mId(board.getMId())
                .bTitle(board.getBTitle())
                .bContent(board.getBContent())
                .bViews(board.getBViews())
                .bCreateDate(board.getBCreateDate())
                .bUpdateDate(board.getBUpdateDate())
                .build();
    }

    @Override
    @Transactional
    public void delete(Long bId) {
        List<FileInfo> list = fileInfoService.getFileInfo(bId);

        if (!CollectionUtils.isEmpty(list)) {
            FileUtil.deleteFiles(list.stream()
                    .map(fileInfo -> FileInfoDTO.builder()
                            .fId(fileInfo.getFId())
                            .bId(fileInfo.getBId())
                            .originalName(fileInfo.getOriginalName())
                            .saveName(fileInfo.getSaveName())
                            .build())
                    .collect(Collectors.toList()));

            for (FileInfo file : list) {
                fileInfoService.delete(list);
            }
        }

        boardMapper.delete(bId);
    }

    @Override
    @Transactional
    public void update(BoardDTO boardDTO) {
        boardMapper.update(Board.builder()
                .bId(boardDTO.getBId())
                .mId(boardDTO.getMId())
                .bTitle(boardDTO.getBTitle())
                .bContent(boardDTO.getBContent())
                .build());

        if (!CollectionUtils.isEmpty(boardDTO.getFiles())) {
            List<FileInfo> list = fileInfoService.getFileInfo(boardDTO.getBId());

            if (!CollectionUtils.isEmpty(list)) {
                FileUtil.deleteFiles(list.stream()
                        .map(fileInfo -> FileInfoDTO.builder()
                                .fId(fileInfo.getFId())
                                .bId(fileInfo.getBId())
                                .originalName(fileInfo.getOriginalName())
                                .saveName(fileInfo.getSaveName())
                                .build())
                        .collect(Collectors.toList()));

                fileInfoService.delete(list);
            }

            try {
                List<FileInfoDTO> files = FileUtil.uploadFiles(boardDTO.getFiles());
                fileInfoService.saveFile(boardDTO.getBId(), files);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
