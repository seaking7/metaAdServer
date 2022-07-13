package dev.practice.ad.interfaces.web;

import dev.practice.ad.application.ad.AppFacade;
import dev.practice.ad.domain.app.AppCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class AppController {

    private final AppFacade appFacade;

    @GetMapping("/home")
    public String viewHome(){
        return "home";
    }

    @GetMapping
    public String listApps(Model model){
        log.info("{listApps} list app ");

        model.addAttribute("appId", "aaa");
        return "app/listApp";
    }

    @GetMapping("/new")
    public String viewInsertApp(Model model){
        model.addAttribute("appKey", "adfadfasf");
        return "app/createAppForm";
    }


    @PostMapping("/new")
    public String insertAppId(AppForm form, Model model){

        log.info("{insertAppId} appId: "+ form.getAppId());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AppCommand appCommand = form.toCommand();
        log.info("appCommand {}", appCommand);
        appFacade.registerApp(appCommand);

        model.addAttribute("appKey", "adfadfasf");

        return "app/createAppForm";
    }


}
