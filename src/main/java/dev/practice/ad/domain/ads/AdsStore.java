package dev.practice.ad.domain.ads;

import java.util.List;

public interface AdsStore {
    Ads store(Ads initAdRequest);

    List<AdsInfo> listAds();
}
