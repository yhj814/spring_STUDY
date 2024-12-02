package com.app.threetier.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TeamVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String teamName;
    private Integer teamNumber;
    private String teamMaster;

    public TeamDTO toDTO(){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(id);
        teamDTO.setTeamName(teamName);
        teamDTO.setTeamNumber(teamNumber);
        teamDTO.setTeamMaster(teamMaster);
        return teamDTO;
    }
}
