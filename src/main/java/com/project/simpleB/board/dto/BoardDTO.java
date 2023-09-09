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
    private Long bId;
    private Long mId;
    private String bTitle;
    private String bContent;
    private Date bCreateDate;
    private Date bUpdateDate;
    private Long bViews;

    List<MultipartFile> files;
}
