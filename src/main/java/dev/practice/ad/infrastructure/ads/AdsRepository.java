package dev.practice.ad.infrastructure.ads;

import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Long> {

    Iterable<Ads> findAdsByAdsTypeEquals(AdsType adsType);
}
