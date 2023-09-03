package com.project.simpleB.board.service;


import com.project.simpleB.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    int write(BoardDTO boardDTO);

    List<BoardDTO> list();

    BoardDTO detail(long bId);
}
