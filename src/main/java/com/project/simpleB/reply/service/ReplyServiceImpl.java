package com.project.simpleB.reply.service;

import com.project.simpleB.paging.Paging;
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
    public Paging list(Long bId, int pageIndex) {
        Paging paging = new Paging(pageIndex, 2);
        List<Reply> list = replyMapper.list(bId, paging);
        int totalCount = replyMapper.count(bId);

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        paging.pagingList(list.stream()
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
                .collect(Collectors.toList()), totalCount);
        System.out.println("paging = " + paging);

        return paging;
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
