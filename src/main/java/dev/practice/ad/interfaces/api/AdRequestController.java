package dev.practice.ad.interfaces.api;

import dev.practice.ad.application.ad.AdRequestFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/meta/v1")
public class AdRequestController {
    private final AdRequestFacade adRequestFacade;

    @GetMapping("/init")
    public String getInitAd(@ModelAttribute AdRequestDto.AdInit adInit){
        log.info("init appId:{}, appKey:{}, macAddress:{}, sdkVersion:{}", adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getSdkVersion());
        String returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<init>\n" +
                "    <uuid></uuid>\n" +
                "    <token></token>\n" +
                "    <viewabilityPolicy>\n" +
                "        <MeasuringScreenAreaSize>0,0,1,1</MeasuringScreenAreaSize>\n" +
                "        <MeasuringScreenArea>100</MeasuringScreenArea>\n" +
                "        <MeasuringInterval>0.2</MeasuringInterval>\n" +
                "        <PollingInterval>1</PollingInterval>\n" +
                "        <PixelGrid>100</PixelGrid>\n" +
                "        <VisibleArea>0.5</VisibleArea>\n" +
                "        <OnScreenLength>0.33</OnScreenLength>\n" +
                "        <SkewAngle>45</SkewAngle>\n" +
                "        <ActiveTime>1</ActiveTime>\n" +
                "    </viewabilityPolicy>\n" +
                "</init>";
        return returnStr;
    }

    @GetMapping("/request")
    public String getRequestAd(@ModelAttribute @Valid AdRequestDto.AdRequest request ){
        log.info("request appId:{}, token:{}, width:{}, height:{}", request.getAppId(), request.getToken(), request.getWidth(), request.getHeight());
        String returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<adsinfo>\n" +
                "    <adMediaType>Image</adMediaType>\n" +
                "    <adUrl>http://203.248.154.18/i20/ads/20220510110642_SB_CA_05_2.0_0510.jpg</adUrl>\n" +
                "    <adsId>1000</adsId>\n" +
                "</adsinfo>";
        return returnStr;
    }

    @GetMapping("/report")
    public String getReportAd(@ModelAttribute @Valid AdRequestDto.AdReport report){
        log.info("report appId:{}, getAdMediaType:{}, getAdMediaType:{}", report.getAppId(), report.getAdMediaType(), report.getAdMediaType());
        String returnStr = "OK";
        return returnStr;
    }

    @GetMapping("/test")
    public void testHeader(@RequestHeader Map<String, Object> requestHeader){
        log.info(requestHeader.toString());

    }


}
