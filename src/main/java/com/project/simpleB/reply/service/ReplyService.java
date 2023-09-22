package com.project.simpleB.reply.service;

import com.project.simpleB.paging.Paging;
import com.project.simpleB.reply.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    Paging list(Long bId, int pageIndex);

    void write(ReplyDTO replyDTO);

    void delete(Long rId);
}
