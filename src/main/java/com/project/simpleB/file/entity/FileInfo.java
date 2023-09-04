package com.project.simpleB.file.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FileInfo {
    private Long fId;
    private Long bId;
    private String originalName;
    private String saveName;
}
