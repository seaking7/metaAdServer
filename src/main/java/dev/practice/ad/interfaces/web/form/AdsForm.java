package dev.practice.ad.interfaces.web.form;

import dev.practice.ad.domain.ads.AdsCommand;
import lombok.Data;

@Data
public class AdsForm {
    private String adsId;
    private String adsName;
    private String materialUrl;

    public AdsCommand toCommand(){
        return AdsCommand.builder()
                .adsId(adsId)
                .adsName(adsName)
                .materialUrl(materialUrl)
                .build();
    }
}
