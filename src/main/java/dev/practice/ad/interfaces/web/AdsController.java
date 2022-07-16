package dev.practice.ad.interfaces.web;

import dev.practice.ad.application.AdsFacade;
import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsCommand;
import dev.practice.ad.domain.ads.AdsInfo;
import dev.practice.ad.domain.ads.AdsType;
import dev.practice.ad.domain.app.AppCommand;
import dev.practice.ad.interfaces.web.form.AdsForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {

    private final AdsFacade adsFacade;

    @ModelAttribute("adsTypes")
    public AdsType[] apsTypes(){
        return AdsType.values();
    }

    @GetMapping
    public String listApps(Model model){
        log.info("{listApps} list app ");
        List<AdsInfo> result = adsFacade.listAds();
        for (AdsInfo adsInfo : result) {
            log.info(adsInfo.toString());
        }
        model.addAttribute("ads", result);
        return "ads/listAds";
    }

    @GetMapping("/new")
    public String viewInsertApp(Model model){
        model.addAttribute("ads", new AdsForm());
        return "ads/createAdsForm";
    }


    @PostMapping("/new")
    public String insertAds(AdsForm form, Model model){

        log.info("{insertAppId} getAdsId: {} {}", form.getAdsId(), form.getAdsType());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AdsCommand adsCommand = form.toCommand();
        log.info("appCommand {}", adsCommand);
        adsFacade.registerAds(adsCommand);

        model.addAttribute("ads", new AdsForm());

        return "ads/createAdsForm";
    }


}
