package com.example.test.Controller;

import com.example.test.DTO.MemberDTO;
import com.example.test.DTO.UserDTO;
import com.example.test.Service.MemberService;
import com.example.test.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final UserService userService;

    @PostMapping("/save")
    public String memberSave(@ModelAttribute MemberDTO memberDTO) {
        UserDTO userDTO = userService.save();
        memberDTO.setUserId(userDTO.getId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setSalt(passwordEncoder.encode(memberDTO.getMemberPassword()));
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO,userDTO);
        return "index";
    }
}
