package com.project.simpleB.file.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoDTO {
    private Long fId;
    private Long bId;
    private String originalName;
    private String saveName;
}
