package com.app.threetier.service.team;

import com.app.threetier.domain.team.TeamVO;
import com.app.threetier.repository.team.TeamDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class TeamServiceImpl implements TeamService {
    private final TeamDAO teamDAO;

    @Override
    public void register(TeamVO teamVO) {
        teamDAO.save(teamVO);  // 팀 등록 메서드
    }

    @Override
    public List<TeamVO> getAllTeams() {
        return teamDAO.findAll();  // 모든 팀 조회
    }

    @Override
    public void update(TeamVO teamVO) {
        teamDAO.update(teamVO);  // 팀 정보 수정
    }

    @Override
    public void delete(Long id) {
        teamDAO.delete(id);  // 팀 삭제
    }
}
