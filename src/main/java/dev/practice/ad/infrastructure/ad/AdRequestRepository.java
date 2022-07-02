package dev.practice.ad.infrastructure.ad;

import dev.practice.ad.domain.ad.AdRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdRequestRepository extends JpaRepository<AdRequest, Long> {
    Optional<AdRequest> findByPartnerToken(String partnerToken);
}
