package dev.practice.ad.interfaces.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class AdRequestDto {
    @NotEmpty(message = "appId 는 필수값입니다")
    private String appId;
    @NotEmpty(message = "token 는 필수값입니다")
    private String token;
    private String tag;
    private String adRole;
    private String duplicatedNum;
    private String adMediaType;
    private String unit;
    private String width;
    private String height;
    private String sdkVersion;

//        public AdRequestCommand toCommand() {
//            return AdRequestCommand.builder()
//                    .a(partnerName)
//                    .businessNo(businessNo)
//                    .email(email)
//                    .build();
//        }

}
