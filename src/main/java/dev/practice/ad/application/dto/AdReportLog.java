package dev.practice.ad.application.dto;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
public class AdReportLog {
    private String requestTime;
    private String adSeq;
    private String adsId;
    private String state;
    private String playTime;


}
