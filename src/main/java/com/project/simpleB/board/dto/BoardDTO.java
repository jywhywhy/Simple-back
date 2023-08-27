package com.project.simpleB.board.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private long bId;
    private long mId;
    private String bTitle;
    private String bContent;
    private Date bCreateDate;
    private Date bUpdateDate;
    private long bViews;
}
