package com.app.mybatis.domain.task;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
    private Long id;
    private String placeDetail;
    private String placeName;
    private int placePrice;

    public PlaceVO toVO() {
        return new PlaceVO(id, placeDetail, placeName, placePrice);
    }
}
