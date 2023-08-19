package com.project.simpleB.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
    private String mName;
    private String username;
    private String password;
}
