package dev.practice.ad.application;

import dev.practice.ad.domain.api.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestFacade {
    private final AdRequestService adRequestService;


    public AdInitInfo fetchInit(AdInitCommand adInitCommand) {
        return adRequestService.processInit(adInitCommand);
    }

    public AdRequestInfo requestAd(AdRequestCommand adRequestCommand) {
        return adRequestService.requestAd(adRequestCommand);
    }
}
