package com.project.simpleB.reply.service;

import com.project.simpleB.reply.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    List<ReplyDTO> list(Long bId);

    void write(ReplyDTO replyDTO);
}
