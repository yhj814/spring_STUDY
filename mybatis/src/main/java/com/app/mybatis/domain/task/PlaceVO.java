package com.app.mybatis.domain.task;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlaceVO {
    private Long id;
    private String placeDetail;
    private String placeName;
    private int placePrice;
}
