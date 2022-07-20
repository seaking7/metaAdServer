package dev.practice.ad.application.dto;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdRequestLog {
    private String requestTime;
    private String adSeq;
    private String appId;
    private String adsId;
    private String materialUrl;


    @Enumerated(EnumType.STRING)
    private AdsType adsType;

}
