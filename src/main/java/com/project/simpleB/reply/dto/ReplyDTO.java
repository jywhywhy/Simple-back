package com.project.simpleB.reply.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private Long rId;
    private Long bId;
    private Long mId;
    private String mName;
    private String rContent;
    private Date rCreateDate;
    private Date rUpdateDate;
    private Long rParentId;
    private Long rDept;
}
