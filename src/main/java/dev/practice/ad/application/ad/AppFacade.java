package dev.practice.ad.application.ad;

import dev.practice.ad.domain.ad.AdRequestCommand;
import dev.practice.ad.domain.ad.AdRequestInfo;
import dev.practice.ad.domain.ad.AdRequestService;
import dev.practice.ad.domain.app.AppCommand;
import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.domain.app.AppService;
import dev.practice.ad.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppFacade {
    private final AppService appService;

    public AppInfo registerApp(AppCommand command) {
        var appInfo = appService.registerApp(command);
        return appInfo;
    }

}
