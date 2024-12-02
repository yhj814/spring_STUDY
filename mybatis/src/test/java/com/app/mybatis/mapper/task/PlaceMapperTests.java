package com.app.mybatis.mapper.task;

import com.app.mybatis.domain.task.PlaceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PlaceMapperTests {
    @Autowired
    private PlaceMapper placeMapper;

    @Test
    public void testInsert() {
        PlaceVO placeVO = new PlaceVO(null,"서울특별시","올림픽공원",15000);
        placeMapper.insert(placeVO);
    }
}
