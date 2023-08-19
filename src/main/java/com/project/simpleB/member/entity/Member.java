package com.project.simpleB.member.entity;

import lombok.*;

@Getter
@Builder
public class Member {
    private long mId;
    private String mName;
    private String username;
    private String password;
}
