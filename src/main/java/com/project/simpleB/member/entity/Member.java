package com.project.simpleB.member.entity;

import lombok.*;

@Getter
@Builder
public class Member {
    private Long mId;
    private String mName;
    private String username;
    private String password;
}
