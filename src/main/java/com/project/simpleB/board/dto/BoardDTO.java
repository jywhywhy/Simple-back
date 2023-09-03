package com.project.simpleB.board.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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
