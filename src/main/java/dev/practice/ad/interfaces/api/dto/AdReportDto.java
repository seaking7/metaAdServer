package dev.practice.ad.interfaces.api.dto;

import dev.practice.ad.domain.ads.AdsType;
import dev.practice.ad.domain.api.AdReportCommand;
import dev.practice.ad.domain.api.AdRequestCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class AdReportDto {
    @NotEmpty(message = "adsId 는 필수값입니다")
    private String adsId;

    @NotEmpty(message = "adsSeq 는 필수값입니다")
    private String adsSeq;
    private String state;
    private String userIp;
    private String playTime;


    public AdReportCommand toCommand() {
        return AdReportCommand.builder()
                .adsId(adsId)
                .adsSeq(adsSeq)
                .state(state)
                .playTime(playTime)
                .build();
    }
}
