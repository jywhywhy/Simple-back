package com.project.simpleB.member.service;

import com.project.simpleB.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    MemberDTO signIn(MemberDTO memberDTO);

    List<MemberDTO> list();

}
