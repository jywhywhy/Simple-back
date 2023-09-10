package com.project.simpleB.reply.service;

import com.project.simpleB.reply.dto.ReplyDTO;
import com.project.simpleB.reply.entity.Reply;
import com.project.simpleB.reply.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyMapper replyMapper;

    @Override
    public List<ReplyDTO> list(Long bId) {
        List<Reply> list = replyMapper.list(bId);

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream()
                .map(reply -> ReplyDTO.builder()
                        .rId(reply.getRId())
                        .bId(reply.getBId())
                        .mId(reply.getMId())
                        .rContent(reply.getRContent())
                        .rCreateDate(reply.getRCreateDate())
                        .rUpdateDate(reply.getRUpdateDate())
                        .rParentId(reply.getRParentId())
                        .rDept(reply.getRDept())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void write(ReplyDTO replyDTO) {
        replyMapper.write(Reply.builder()
                .rId(replyDTO.getRId())
                .bId(replyDTO.getBId())
                .mId(replyDTO.getMId())
                .rContent(replyDTO.getRContent())
                .rParentId(replyDTO.getRParentId())
                .rDept(replyDTO.getRDept())
                .build());
    }
}
