package dev.practice.ad.application;

import com.google.gson.Gson;
import dev.practice.ad.application.dto.AdReportLog;
import dev.practice.ad.application.dto.AdRequestLog;
import dev.practice.ad.domain.api.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestFacade {
    private final AdRequestService adRequestService;
    private Logger reportLogger = LoggerFactory.getLogger("accReportFile");

    public AdInitInfo fetchInit(AdInitCommand adInitCommand) {
        return adRequestService.processInit(adInitCommand);
    }

    public AdRequestInfo requestAd(AdRequestCommand adRequestCommand) {
        AdRequestInfo adRequestInfo = adRequestService.requestAd(adRequestCommand);
        writeLogRequestAd(adRequestCommand, adRequestInfo);
        return adRequestInfo;
    }

    public void reportAd(AdReportCommand adReportCommand) {
        Gson gson = new Gson();

        AdReportLog adReportLog = new AdReportLog();
        adReportLog.setAdSeq(adReportCommand.getAdsSeq());
        adReportLog.setAdsId(adReportCommand.getAdsId());
        adReportLog.setState(adReportCommand.getState());
        adReportLog.setPlayTime(adReportCommand.getPlayTime());
        adReportLog.setRequestTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
        reportLogger.info(gson.toJson(adReportLog));
    }

    private void writeLogRequestAd(AdRequestCommand adRequestCommand, AdRequestInfo adRequestInfo) {
        Gson gson = new Gson();
        String[] split = adRequestInfo.getAdsSeq().split(",");
        for (String s : split) {
            AdRequestLog adRequestLog = new AdRequestLog();
            adRequestLog.setAdSeq(s);
            adRequestLog.setAppId(adRequestCommand.getAppId());
            adRequestLog.setAdsId(adRequestInfo.getAdsId());
            adRequestLog.setAdsType(adRequestInfo.getAdsType());
            adRequestLog.setState("2");
            adRequestLog.setRequestTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
            reportLogger.info(gson.toJson(adRequestLog));
        }
    }
}
