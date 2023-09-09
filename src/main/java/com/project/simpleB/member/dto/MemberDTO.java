package com.project.simpleB.member.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long mId;
    private String mName;
    private String username;
    private String password;
}
