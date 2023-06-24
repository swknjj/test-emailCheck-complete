package com.example.test.Entity;

import com.example.test.DTO.MemberDTO;
import com.example.test.Util.UtilClass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String memberId;

    @Column(length = 5, nullable = false)
    private String memberName;

    @Column(length = 1000, nullable = false)
    private String memberPassword;

    @Column(length = 1000)
    private String salt;

    @Column(length = 50,nullable = false)
    private String memberBirth;

    @Column(length = 100,nullable = false)
    private String memberEmail;

    @Column
    @ColumnDefault("0")
    private int memberWallet;

    @Column
    @ColumnDefault("0")
    private Time memberTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SeatEntity> seatEntityList = new ArrayList<>();

    public static MemberEntity toSaveEntity(MemberDTO memberDTO,UserEntity userEntity) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberWallet(memberDTO.getMemberWallet());
        memberEntity.setSalt(memberDTO.getSalt());
        memberEntity.setUserEntity(userEntity);
        return memberEntity;
    }
}