package dev.practice.ad.domain.api;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdReportCommand {
    private String adsId;
    private String adsSeq;
    private String state;
    private String playTime;

}
