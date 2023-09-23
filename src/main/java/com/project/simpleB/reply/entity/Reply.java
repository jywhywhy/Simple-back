package com.project.simpleB.reply.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Reply {
    private Long rId;
    private Long bId;
    private Long mId;
    private String rContent;
    private Date rCreateDate;
    private Date rUpdateDate;
    private Long rParentId;
    private Long rDept;
}
