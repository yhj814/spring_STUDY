package com.app.jpa.domain.entity;

import com.app.jpa.domain.type.BrandType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@ToString
@Table(name="TBL_SUPER_CAR")
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//TBL_SUPER_CAR
public class SuperCar {
//    고유 번호
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    브랜드(벤츠(default), 현대, 기아)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'BENZ'")
    private BrandType brand;
//    색상
    @Column(nullable = false)
    private String color;
//    가격
    private int price;
}
