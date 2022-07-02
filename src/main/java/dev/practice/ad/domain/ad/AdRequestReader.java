package dev.practice.ad.domain.ad;

public interface AdRequestReader {
    AdRequest getPartner(Long partnerId);
    AdRequest getPartner(String partnerToken);
}
