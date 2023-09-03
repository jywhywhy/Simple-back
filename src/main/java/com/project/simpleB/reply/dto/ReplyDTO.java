package com.project.simpleB.reply.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private long rId;
    private long bId;
    private long mId;
    private String rContent;
    private Date rCreateDate;
    private Date rUpdateDate;
    private Long rParentId;
    private long rDept;
}
