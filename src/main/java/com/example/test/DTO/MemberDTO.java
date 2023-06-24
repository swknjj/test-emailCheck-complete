package com.example.test.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String salt;
    private String memberName;
    private String memberBirth;
    private String memberEmail;
    private int memberWallet;
    private Time memberTime;
    private Long userId;
}
