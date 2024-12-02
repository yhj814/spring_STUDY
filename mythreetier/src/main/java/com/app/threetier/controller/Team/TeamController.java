package com.app.threetier.controller.Team;

import com.app.threetier.domain.team.TeamDTO;
import com.app.threetier.domain.team.TeamVO;
import com.app.threetier.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/team/*")
@RequiredArgsConstructor
@Slf4j
public class TeamController {
    private final TeamService teamService;

    @GetMapping("register")
    public void goToRegisterPage(TeamDTO teamDTO) {;}

    @PostMapping("register")
    public RedirectView register(TeamDTO teamDTO) {
        teamService.register(teamDTO.toVO());
        return new RedirectView("/team/list");
    }

    // 팀 목록 조회 (GET 요청)
    @GetMapping("list")
    public String goToListPage(Model model) {
        List<TeamDTO> teamList = teamService.getAllTeams()
                .stream()
                .map(TeamVO::toDTO)
                .collect(Collectors.toList());

        model.addAttribute("teamList", teamList);
        return "team/list";
    }


    @GetMapping("/update")
    public String goToUpdatePage(@RequestParam Long id, Model model) {
        TeamDTO teamDTO = teamService.getAllTeams().stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .map(TeamVO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Invalid team Id:" + id));

        model.addAttribute("teamDTO", teamDTO);
        return "team/update";
    }

    @PostMapping("/update")
    public String updateTeam(@ModelAttribute TeamDTO teamDTO) {
        teamService.update(teamDTO.toVO());
        return "redirect:/team/list";
    }

    @PostMapping("/delete")
    public String deleteTeam(@RequestParam Long id) {
        teamService.delete(id);
        return "redirect:/team/list";  // 삭제 후 팀 목록 페이지로 리다이렉트
    }

}
