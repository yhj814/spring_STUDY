package com.app.threetier.mapper;

import com.app.threetier.domain.team.TeamDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TeamMapperTests {
    @Autowired
    private TeamMapper teamMapper;

    @Test
    public void testInsert() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("강남타이거즈");
        teamDTO.setTeamNumber(10);
        teamDTO.setTeamMaster("홍길동");

        teamMapper.insert(teamDTO.toVO());
    }

}
