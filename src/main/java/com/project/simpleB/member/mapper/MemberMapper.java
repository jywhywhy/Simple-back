package com.project.simpleB.member.mapper;

import com.project.simpleB.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    Member signIn(Member member);

    int signUp(Member member);

    List<Member> list();

}
