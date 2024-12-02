package com.app.threetier.repository.team;

import com.app.threetier.domain.team.TeamVO;
import com.app.threetier.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamDAO {
    private final TeamMapper teamMapper;

//    팀등록
    public void save(TeamVO teamVO) {teamMapper.insert(teamVO);}

//  팀조희
    public List<TeamVO> findAll() {return teamMapper.selectAll();}

//  팀수정
    public void update(TeamVO teamVO) {teamMapper.update(teamVO);}

//  팀삭제
    public void delete(Long id){
        teamMapper.delete(id);
    }
}
