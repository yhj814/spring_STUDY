package com.app.threetier.service.team;

import com.app.threetier.domain.team.TeamVO;

import java.util.List;

public interface TeamService {
    public void register(TeamVO teamVO);

    public List<TeamVO> getAllTeams();

    public void update(TeamVO teamVO);

    public void delete(Long id);
}
