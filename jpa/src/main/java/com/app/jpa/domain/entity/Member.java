package com.app.jpa.domain.entity;

import com.app.jpa.domain.type.MemberType;
import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter @Setter
@Entity
@Table(name = "TBL_MEMBER")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String memberName;
    @Column(unique = true, nullable = false)
    private String memberEmail;
    private String memberPassword;
//    private Integer memberAge;
    private int memberAge;
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'MEMBER'")
    private MemberType memberType;

    @Builder
    public Member(Long id, @NonNull String memberName, String memberEmail, String memberPassword, int memberAge, MemberType memberType) {
        this.id = id;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberAge = memberAge;
        this.memberType = memberType;
    }
}
















