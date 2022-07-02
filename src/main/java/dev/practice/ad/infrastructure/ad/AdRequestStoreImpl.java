package dev.practice.ad.infrastructure.ad;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.ad.AdRequest;
import dev.practice.ad.domain.ad.AdRequestStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdRequestStoreImpl implements AdRequestStore {

    private final AdRequestRepository adRequestRepository;

    @Override
    public AdRequest store(AdRequest adRequest) {
        if (StringUtils.isEmpty(adRequest.getPartnerToken())) throw new InvalidParamException("partner.getPartnerToken()");
        if (StringUtils.isEmpty(adRequest.getPartnerName())) throw new InvalidParamException("partner.getPartnerName()");
        if (StringUtils.isEmpty(adRequest.getBusinessNo())) throw new InvalidParamException("partner.getBusinessNo()");
        if (StringUtils.isEmpty(adRequest.getEmail())) throw new InvalidParamException("partner.getEmail()");
        if (adRequest.getStatus() == null) throw new InvalidParamException("partner.getStatus()");

        return adRequestRepository.save(adRequest);
    }
}
