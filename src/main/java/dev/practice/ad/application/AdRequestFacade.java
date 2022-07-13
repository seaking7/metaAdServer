package dev.practice.ad.application;

import dev.practice.ad.domain.notification.NotificationService;
import dev.practice.ad.domain.ad.AdRequestCommand;
import dev.practice.ad.domain.ad.AdRequestInfo;
import dev.practice.ad.domain.ad.AdRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestFacade {
    private final AdRequestService adRequestService;
    private final NotificationService notificationService;

    public AdRequestInfo registerPartner(AdRequestCommand command) {
        var adRequestInfo = adRequestService.registerPartner(command);
        notificationService.sendEmail(adRequestInfo.getEmail(), "title", "description");
        return adRequestInfo;
    }
}
