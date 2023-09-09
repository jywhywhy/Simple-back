package com.project.simpleB.board.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Board {
    private Long bId;
    private Long mId;
    private String bTitle;
    private String bContent;
    private Date bCreateDate;
    private Date bUpdateDate;
    private Long bViews;
}
