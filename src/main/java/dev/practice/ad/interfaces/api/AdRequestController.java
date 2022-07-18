package dev.practice.ad.interfaces.api;

import dev.practice.ad.application.AdRequestFacade;
import dev.practice.ad.common.util.XmlGenerator;
import dev.practice.ad.domain.api.AdInitCommand;
import dev.practice.ad.domain.api.AdInitInfo;
import dev.practice.ad.domain.api.AdRequestCommand;
import dev.practice.ad.domain.api.AdRequestInfo;
import dev.practice.ad.interfaces.api.dto.AdInitDto;
import dev.practice.ad.interfaces.api.dto.AdReportDto;
import dev.practice.ad.interfaces.api.dto.AdRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/meta/v1")
public class AdRequestController {

    private final AdRequestFacade adRequestFacade;

    @GetMapping("/init")
    public String getInitAd(@ModelAttribute @Valid AdInitDto adInit){
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

    @GetMapping("/init2")
    public String getInitAd2(@ModelAttribute @Valid AdInitDto adInit) throws JAXBException {
        log.info("init appId:{}, appKey:{}, macAddress:{}, uuid:{}, sdkVersion:{}",
                adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getUuid(), adInit.getSdkVersion());
        AdInitCommand adInitCommand = adInit.toCommand();

        AdInitInfo adInitInfo = adRequestFacade.fetchInit(adInitCommand);
        log.info("result === {}", adInitInfo.toString());

        return XmlGenerator.marshalObjectToXml(adInitInfo);
    }


    @GetMapping("/init3")
    public AdInitInfo getInitAd3(@ModelAttribute @Valid AdInitDto adInit) throws JAXBException {
        log.info("init appId:{}, appKey:{}, macAddress:{}, uuid:{}, sdkVersion:{}",
                adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getUuid(), adInit.getSdkVersion());
        AdInitCommand adInitCommand = adInit.toCommand();

        AdInitInfo adInitInfo = adRequestFacade.fetchInit(adInitCommand);
        log.info("result === {}", adInitInfo.toString());

        return adInitInfo;
    }

    @GetMapping("/request")
    public String getRequestAd(@ModelAttribute("AdRequestDto") @Valid AdRequestDto request ){
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

    @GetMapping("/request2")
    public String getRequestAd2(@ModelAttribute("AdRequestDto") @Valid AdRequestDto request ) throws JAXBException {
        log.info("request appId:{}, token:{}, width:{}, height:{} getDuplicatedNum:{}",
                request.getAppId(), request.getToken(), request.getWidth(), request.getHeight(), request.getDuplicatedNum());
        AdRequestCommand adRequestCommand = request.toCommand();

        AdRequestInfo adRequestInfo = adRequestFacade.requestAd(adRequestCommand);
        log.info("result === {}", adRequestInfo.toString());
        return XmlGenerator.marshalObjectToXml(adRequestInfo);
    }


        @GetMapping("/report")
    public String getReportAd(@ModelAttribute("AdReportDto") @Valid AdReportDto report){
        log.info("report appId:{}, getAdMediaType:{}, getAdMediaType:{}", report.getAppId(), report.getAdMediaType(), report.getAdMediaType());
        String returnStr = "OK";
        return returnStr;
    }

    @GetMapping("/test")
    public void testHeader(@RequestHeader Map<String, Object> requestHeader){
        log.info(requestHeader.toString());
    }

}
