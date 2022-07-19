package dev.practice.ad.interfaces.api.dto;

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
}
