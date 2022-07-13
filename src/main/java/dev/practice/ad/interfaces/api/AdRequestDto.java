package dev.practice.ad.interfaces.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

public class AdRequestDto {


    @Getter
    @ToString
    public static class AdInit {
        @NotEmpty(message = "appId 는 필수값입니다")
        private String appId;
        private String appKey;
        private String macAddress;
        private String sdkVersion;
    }


    @Getter
    @Setter
    @ToString
    public static class AdRequest
    {
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

    @Getter
    @ToString
    public static class AdReport {
        @NotEmpty(message = "appId 는 필수값입니다")
        private String appId;

        @NotEmpty(message = "uuid 는 필수값입니다")
        private String uuid;
        private String adsId;
        private String adMediaType;

    }
}
