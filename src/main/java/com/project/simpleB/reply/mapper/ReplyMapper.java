package com.project.simpleB.reply.mapper;

import com.project.simpleB.common.Paging;
import com.project.simpleB.reply.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<Reply> list(@Param("bId") Long bId, Paging paging);

    int write(Reply build);

    int count(Long bId);

    void delete(Long rId);
}
