package com.project.simpleB.reply.mapper;

import com.project.simpleB.reply.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<Reply> list(Long bId);

    int write(Reply build);
}
