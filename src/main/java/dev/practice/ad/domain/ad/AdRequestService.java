package dev.practice.ad.domain.ad;

public interface AdRequestService {
    AdRequestInfo registerPartner(AdRequestCommand command);
    AdRequestInfo getPartnerInfo(String partnerToken);
    AdRequestInfo enablePartner(String partnerToken);
    AdRequestInfo disablePartner(String partnerToken);
}
