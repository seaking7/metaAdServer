package dev.practice.ad.infrastructure.ad;

import dev.practice.ad.domain.ads.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Long> {
}
