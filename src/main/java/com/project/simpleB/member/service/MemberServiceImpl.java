package com.project.simpleB.member.service;


import com.project.simpleB.member.dto.MemberDTO;
import com.project.simpleB.member.entity.Member;
import com.project.simpleB.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public MemberDTO signIn(MemberDTO memberDTO) {
        Member member = memberMapper.signIn(
                Member.builder()
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .build());

        if (member == null) {
            return null;
        }

        return MemberDTO.builder()
                .mId(member.getMId())
                .mName(member.getMName())
                .build();
    }

    @Override
    public List<MemberDTO> list() {
        List<Member> memberList = memberMapper.list();

        return memberList.stream()
                .map(member -> MemberDTO.builder()
                        .mName(member.getMName())
                        .build())
                .collect(Collectors.toList());
    }

}
