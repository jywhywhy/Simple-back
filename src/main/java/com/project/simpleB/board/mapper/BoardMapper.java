package com.project.simpleB.board.mapper;

import com.project.simpleB.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int write(Board build);

    List<Board> list();

    Board detail(long bId);
}
