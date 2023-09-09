package com.project.simpleB.board.service;


import com.project.simpleB.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    void write(BoardDTO boardDTO);

    List<BoardDTO> list();

    BoardDTO detail(Long bId);

    void delete(Long bId);

    void update(BoardDTO boardDTO);
}
