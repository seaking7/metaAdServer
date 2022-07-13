package dev.practice.ad.domain.ads;

import lombok.Getter;

@Getter
public class AdsInfo {
    private final Long id;
    private final String adsId;
    private final String adsName;
    private final String materialUrl;
    private final String status;

    public AdsInfo(Ads adRequest) {
        this.id = adRequest.getId();
        this.adsId = adRequest.getAdsId();
        this.adsName = adRequest.getAdsName();
        this.materialUrl = adRequest.getMaterialUrl();
        this.status = adRequest.getStatus().getDescription();
    }
}
