package com.example.test.Service;

import com.example.test.DTO.MemberDTO;
import com.example.test.DTO.UserDTO;
import com.example.test.Entity.MemberEntity;
import com.example.test.Entity.UserEntity;
import com.example.test.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO, UserDTO userDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO, UserEntity.toEntity(userDTO));
        memberRepository.save(memberEntity);
    }
}
