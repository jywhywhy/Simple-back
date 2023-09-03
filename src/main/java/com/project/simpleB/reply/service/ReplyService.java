package com.project.simpleB.reply.service;

import com.project.simpleB.reply.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    List<ReplyDTO> list(long bId);

    int write(ReplyDTO replyDTO);
}
