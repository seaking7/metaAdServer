package dev.practice.ad.interfaces.web.form;

import dev.practice.ad.domain.ads.AdsCommand;
import dev.practice.ad.domain.ads.AdsType;
import lombok.Data;

@Data
public class AdsForm {
    private Long id;
    private String adsId;
    private String adsName;
    private String materialUrl;
    private String adsWidth;
    private String adsHeight;
    private AdsType adsType;

    public AdsCommand toCommand(){
        return AdsCommand.builder()
                .adsId(adsId)
                .adsName(adsName)
                .materialUrl(materialUrl)
                .adsWidth(adsWidth)
                .adsHeight(adsHeight)
                .adsType(adsType)
                .build();
    }
}
