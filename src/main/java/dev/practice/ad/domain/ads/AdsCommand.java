package dev.practice.ad.domain.ads;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdsCommand {
    private final String adsId;
    private final String adsName;
    private final String materialUrl;
    private final String adsWidth;
    private final String adsHeight;

    public Ads toEntity() {
        return Ads.builder()
                .adsId(adsId)
                .adsName(adsName)
                .materialUrl(materialUrl)
                .adsWidth(adsWidth)
                .adsHeight(adsHeight)
                .build();
    }
}
