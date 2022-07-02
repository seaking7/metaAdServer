package dev.practice.ad.infrastructure.ad;

import dev.practice.ad.common.exception.EntityNotFoundException;
import dev.practice.ad.domain.ad.AdRequest;
import dev.practice.ad.domain.ad.AdRequestReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdRequestReadImpl implements AdRequestReader {
    private final AdRequestRepository adRequestRepository;

    @Override
    public AdRequest getPartner(Long partnerId) {
        return adRequestRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public AdRequest getPartner(String partnerToken) {
        return adRequestRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
