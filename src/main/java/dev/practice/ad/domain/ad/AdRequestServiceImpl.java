package dev.practice.ad.domain.ad;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestServiceImpl implements AdRequestService {
    private final AdRequestStore adRequestStore;
    private final AdRequestReader adRequestReader;

    @Override
    @Transactional
    public AdRequestInfo registerPartner(AdRequestCommand command) {
        var initAdRequest = command.toEntity();
        AdRequest adRequest = adRequestStore.store(initAdRequest);
        return new AdRequestInfo(adRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public AdRequestInfo getPartnerInfo(String partnerToken) {
        AdRequest adRequest = adRequestReader.getPartner(partnerToken);
        return new AdRequestInfo(adRequest);
    }

    @Override
    @Transactional
    public AdRequestInfo enablePartner(String partnerToken) {
        AdRequest adRequest = adRequestReader.getPartner(partnerToken);
        adRequest.enable();
        return new AdRequestInfo(adRequest);
    }

    @Override
    @Transactional
    public AdRequestInfo disablePartner(String partnerToken) {
        AdRequest adRequest = adRequestReader.getPartner(partnerToken);
        adRequest.disable();
        return new AdRequestInfo(adRequest);
    }
}
