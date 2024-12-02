package com.app.threetier.controller.market;

import com.app.threetier.domain.market.MarketDTO;
import com.app.threetier.domain.market.MarketVO;
import com.app.threetier.service.market.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/market/*")
@RequiredArgsConstructor
@Slf4j
public class MarketController {
    private final MarketService marketService;

    @GetMapping("register")
    public void goToRegister(MarketDTO marketDTO) {;}

    @PostMapping("register")
    public RedirectView register(MarketDTO marketDTO) {
        marketService.register(marketDTO.toVO());
        return new RedirectView("/market/found");
    }
    @GetMapping("found")
    public void goToFound(MarketDTO marketDTO) {;}

    @PostMapping("found")
    public RedirectView found(MarketDTO marketDTO) {
        Optional<MarketVO> marketOpt = marketService.found(marketDTO.toVO());

        if (marketOpt.isPresent()) {
            MarketVO market = marketOpt.get();
            log.info("제품있음");
            return new RedirectView("read?id="+market.getId());
        }else {
            log.info("제품없음");
            return new RedirectView("found?error=true");
        }
    }

    @GetMapping(value = {"read", "update"})
    public void goToRead(Long id , Model model) {
        model.addAttribute("marketDTO", marketService.getMarket(id).get().toDTO());
    }

    @PostMapping("update")
    public RedirectView update(MarketDTO marketDTO) {
        log.info(marketDTO.toString());
        marketService.update(marketDTO.toVO());
        return new RedirectView("/market/read?id="+marketDTO.getId());
    }

    @GetMapping("delete")
    public RedirectView delete(Long id) {
        marketService.delete(id);
        return new RedirectView("/market/found");
    }
}
