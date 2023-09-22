package com.project.simpleB.board.service;


import com.project.simpleB.board.dto.BoardDTO;
import com.project.simpleB.paging.Paging;

import java.util.List;

public interface BoardService {
    void write(BoardDTO boardDTO);

    Paging list(int pageIndex);

    BoardDTO detail(Long bId);

    void delete(Long bId);

    void update(BoardDTO boardDTO);
}
