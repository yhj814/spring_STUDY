package com.app.threetier.mapper;

import com.app.threetier.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeamMapper {
//    팀등록
    public void insert(TeamVO teamVO);

//    팀조회
     public List<TeamVO> selectAll();

//   팀수정
    public void update(TeamVO teamVO);

//  팀삭제
    public void delete(Long id);
}
