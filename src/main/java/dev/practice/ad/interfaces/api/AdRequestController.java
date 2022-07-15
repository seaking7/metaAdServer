package dev.practice.ad.interfaces.api;

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

    @GetMapping("/init")
    public String getInitAd(@ModelAttribute("AdRequestDto.AdInit") AdRequestDto.AdInit adInit){
        log.info("init appId:{}, appKey:{}, macAddress:{}, uuid:{}, sdkVersion:{}",
                adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getUuid(), adInit.getSdkVersion());
        String returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<init>\n" +
                "    <uuid>a123456789</uuid>\n" +
                "    <token>5F1059FF008C294B854F44E80BF29AF7794725E7F798F92A30E82D80C4F0CF62</token>\n" +
                "    <viewabilityPolicy>\n" +
                "        <MeasuringScreenArea_x>0</MeasuringScreenArea_x>\n" +
                "        <MeasuringScreenArea_y>0</MeasuringScreenArea_y>\n" +
                "        <MeasuringScreenArea_width>1</MeasuringScreenArea_width>\n" +
                "        <MeasuringScreenArea_height>1</MeasuringScreenArea_height>\n" +
                "        <MaxMeasuringCount>100</MaxMeasuringCount>\n" +
                "        <MeasuringInterval>0.2</MeasuringInterval>\n" +
                "        <WatingInterval>1</WatingInterval>\n" +
                "        <ViewableTimeImage>1</ViewableTimeImage>\n" +
                "        <ViewableTimeVideo>2</ViewableTimeVideo>\n" +
                "        <VisibleArea>0.5</VisibleArea>\n" +
                "        <PixelGrid>100</PixelGrid>\n" +
                "        <ReferenceScreenHandheld_x>1024</ReferenceScreenHandheld_x>\n" +
                "        <ReferenceScreenHandheld_y>768</ReferenceScreenHandheld_y>\n" +
                "        <ReferenceScreenBig_x>1536</ReferenceScreenBig_x>\n" +
                "        <ReferenceScreenBig_y>864</ReferenceScreenBig_y>\n" +
                "        <ScreenRelativeLength>0.33</ScreenRelativeLength>\n" +
                "        <SkewAngle>45</SkewAngle>\n" +
                "    </viewabilityPolicy>\n" +
                "</init>";
        return returnStr;
    }

    @GetMapping("/request")
    public String getRequestAd(@ModelAttribute("AdRequestDto.AdRequest") @Valid AdRequestDto.AdRequest request ){
        log.info("request appId:{}, token:{}, width:{}, height:{} duplicate:{}",
                request.getAppId(), request.getToken(), request.getWidth(), request.getHeight(), request.getDuplicatedNum());

        String returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<adsinfo>\n" +
                "    <adMediaType>Image</adMediaType>\n" +
                "    <adUrl>http://203.248.154.18/i20/ads/20220510110642_SB_CA_05_2.0_0510.jpg</adUrl>\n" +
                "    <adsId>1000</adsId>\n" +
                "</adsinfo>";
        if(request.getAdMediaType().equals("Image") && request.getDuplicatedNum().equals("2")){
            returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<adsinfo>\n" +
                    "    <adMediaType>Image</adMediaType>\n" +
                    "    <adUrl>https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/ad_corona.jpeg</adUrl>\n" +
                    "    <adsSeq>1000,1001</adsSeq>\n" +
                    "</adsinfo>";
        } else if (request.getAdMediaType().equals("Image") && request.getDuplicatedNum().equals("6")){
            returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<adsinfo>\n" +
                    "    <adMediaType>Image</adMediaType>\n" +
                    "    <adUrl>https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/ilovewoori.jpeg</adUrl>\n" +
                    "    <adsSeq>1500,1501,1502,1503,1504,1505</adsSeq>\n" +
                    "</adsinfo>";

        } else if (request.getAdMediaType().equals("Video") && request.getDuplicatedNum().equals("1")){
            returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<adsinfo>\n" +
                    "    <adMediaType>Video</adMediaType>\n" +
                    "    <adUrl>https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/uplus_ads_pre.mp4</adUrl>\n" +
                    "    <adsSeq>2000</adsSeq>\n" +
                    "</adsinfo>";
        } else if (request.getAdMediaType().equals("Video") && request.getDuplicatedNum().equals("4")){
            returnStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<adsinfo>\n" +
                    "    <adMediaType>Video</adMediaType>\n" +
                    "    <adUrl>https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/uplus_ads_pre.mp4</adUrl>    \n" +
                    "    <adsSeq>3001,3002,3003,3004</adsSeq>\n" +
                    "</adsinfo>";

        }

        return returnStr;
    }

    @GetMapping("/report")
    public String getReportAd(@ModelAttribute("AdRequestDto.AdReport") @Valid AdRequestDto.AdReport report){
        log.info("report appId:{}, getAdMediaType:{}, getAdMediaType:{}", report.getAppId(), report.getAdMediaType(), report.getAdMediaType());
        String returnStr = "OK";
        return returnStr;
    }

    @GetMapping("/test")
    public void testHeader(@RequestHeader Map<String, Object> requestHeader){
        log.info(requestHeader.toString());

    }


}
