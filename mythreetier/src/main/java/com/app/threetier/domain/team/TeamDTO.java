package com.app.threetier.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String teamName;
    private Integer teamNumber;
    private String teamMaster;

    public TeamVO toVO(){
        return new TeamVO(id, teamName, teamNumber, teamMaster);
    }
}
