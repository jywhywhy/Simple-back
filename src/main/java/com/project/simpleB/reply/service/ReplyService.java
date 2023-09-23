package com.project.simpleB.reply.service;

import com.project.simpleB.common.Paging;
import com.project.simpleB.reply.dto.ReplyDTO;

public interface ReplyService {
    Paging list(Long bId, int pageIndex);

    void write(ReplyDTO replyDTO);

    void delete(Long rId);
}
