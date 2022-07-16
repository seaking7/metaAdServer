package dev.practice.ad.interfaces.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class AdReportDto {
    @NotEmpty(message = "appId 는 필수값입니다")
    private String appId;

    @NotEmpty(message = "uuid 는 필수값입니다")
    private String uuid;
    private String adsId;
    private String adMediaType;
}
