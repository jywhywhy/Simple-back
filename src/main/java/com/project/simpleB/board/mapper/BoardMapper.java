package com.project.simpleB.board.mapper;

import com.project.simpleB.board.entity.Board;
import com.project.simpleB.paging.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int write(Board build);

    List<Board> list(Paging paging);

    Board detail(Long bId);

    void delete(Long bId);

    void update(Board build);

    int count();
}
