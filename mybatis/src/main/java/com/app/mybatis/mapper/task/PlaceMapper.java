package com.app.mybatis.mapper.task;

import com.app.mybatis.domain.task.PlaceVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlaceMapper {
//    장소입력
     public void insert(PlaceVO placeVO);

//    장소삭제
}
