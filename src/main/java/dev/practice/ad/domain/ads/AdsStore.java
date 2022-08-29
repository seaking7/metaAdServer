package dev.practice.ad.domain.ads;

import dev.practice.ad.domain.api.AdRequestCommand;
import dev.practice.ad.domain.api.AdRequestInfo;

import java.util.List;
import java.util.Optional;

public interface AdsStore {
    Ads store(Ads initAdRequest);

    List<AdsInfo> listAds();

    Ads getAdsById(Long id);

    void deleteById(Long id);

    List<Ads> findAds(AdRequestCommand adRequestCommand);
}
