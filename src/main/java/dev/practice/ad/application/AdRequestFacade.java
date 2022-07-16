package dev.practice.ad.application;

import dev.practice.ad.domain.api.AdInitCommand;
import dev.practice.ad.domain.api.AdRequestInfo;
import dev.practice.ad.domain.api.AdRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestFacade {
    private final AdRequestService adRequestService;


    public AdRequestInfo fetchInit(AdInitCommand adInitCommand) {
        return adRequestService.processInit(adInitCommand);
    }
}
