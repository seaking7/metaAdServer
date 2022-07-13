package dev.practice.ad.domain.ads;

import java.util.List;

public interface AdsService {
    AdsInfo registerAds(AdsCommand command);
    List<AdsInfo> listAds();

}
