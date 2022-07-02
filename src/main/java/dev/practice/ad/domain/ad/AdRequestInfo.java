package dev.practice.ad.domain.ad;

import lombok.Getter;

@Getter
public class AdRequestInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final AdRequest.Status status;

    public AdRequestInfo(AdRequest adRequest) {
        this.id = adRequest.getId();
        this.partnerToken = adRequest.getPartnerToken();
        this.partnerName = adRequest.getPartnerName();
        this.businessNo = adRequest.getBusinessNo();
        this.email = adRequest.getEmail();
        this.status = adRequest.getStatus();
    }
}
