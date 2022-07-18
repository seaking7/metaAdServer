package dev.practice.ad.domain.ads;

import dev.practice.ad.domain.api.AdRequestInfo;

import java.util.List;

public interface AdsStore {
    Ads store(Ads initAdRequest);

    List<AdsInfo> listAds();

    Ads getAdsById(Long id);

    void deleteById(Long id);

    Iterable<Ads> findAds(AdsType adsType);
}
