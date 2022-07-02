package dev.practice.ad.domain.ad;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdRequestCommand {
    private final String partnerName;
    private final String businessNo;
    private final String email;

    public AdRequest toEntity() {
        return AdRequest.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
