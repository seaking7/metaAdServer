package dev.practice.ad.interfaces.ad;

import dev.practice.ad.domain.ad.AdRequest;
import dev.practice.ad.domain.ad.AdRequestCommand;
import dev.practice.ad.domain.ad.AdRequestInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AdRequestDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotEmpty(message = "partnerName 는 필수값입니다")
        private String partnerName;

        @NotEmpty(message = "businessNo 는 필수값입니다")
        private String businessNo;

        @Email(message = "email 형식에 맞아야 합니다")
        @NotEmpty(message = "email 는 필수값입니다")
        private String email;

        public AdRequestCommand toCommand() {
            return AdRequestCommand.builder()
                    .partnerName(partnerName)
                    .businessNo(businessNo)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final AdRequest.Status status;

        public RegisterResponse(AdRequestInfo adRequestInfo) {
            this.partnerToken = adRequestInfo.getPartnerToken();
            this.partnerName = adRequestInfo.getPartnerName();
            this.businessNo = adRequestInfo.getBusinessNo();
            this.email = adRequestInfo.getEmail();
            this.status = adRequestInfo.getStatus();
        }
    }
}
