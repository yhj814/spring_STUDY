package com.app.mybatis.controller.task;

import com.app.mybatis.domain.task.PlaceDTO;
import com.app.mybatis.mapper.task.PlaceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceMapper placeMapper;

//    @GetMapping("insert")
//    public void(PlaceDTO placeDTO){
//        placeMapper.insert(placeDTO.toVO());
//    }
}
