package com.project.simpleB.board.service;

import com.project.simpleB.board.dto.BoardDTO;
import com.project.simpleB.board.entity.Board;
import com.project.simpleB.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public int write(BoardDTO boardDTO) {
        System.out.println(boardDTO.getMId());
        return boardMapper.write(Board.builder()
                .mId(boardDTO.getMId())
                .bTitle(boardDTO.getBTitle())
                .bContent(boardDTO.getBContent())
                .build());
    }

    @Override
    public List<BoardDTO> list() {
        List<Board> boardList = boardMapper.list();

        return boardList.stream()
                .map(board -> BoardDTO.builder()
                        .bId(board.getBId())
                        .mId(board.getMId())
                        .bTitle(board.getBTitle())
                        .bContent(board.getBContent())
                        .bCreateDate(board.getBCreateDate())
                        .bViews(board.getBViews())
                        .build())
                .collect(Collectors.toList());
    }
}
