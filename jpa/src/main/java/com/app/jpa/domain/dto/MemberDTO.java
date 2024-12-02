package com.app.jpa.domain.dto;

import com.app.jpa.domain.type.MemberType;
import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
public class MemberDTO {
    private Long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
    private MemberType memberType;
}
















