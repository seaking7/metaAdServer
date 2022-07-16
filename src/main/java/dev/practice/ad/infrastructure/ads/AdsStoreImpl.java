package dev.practice.ad.infrastructure.ads;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsInfo;
import dev.practice.ad.domain.ads.AdsStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdsStoreImpl implements AdsStore {

    private final AdsRepository adsRepository;

    @Override
    public Ads store(Ads adRequest) {
        if (StringUtils.isEmpty(adRequest.getAdsId())) throw new InvalidParamException("ads.getAdsId()");
        if (adRequest.getStatus() == null) throw new InvalidParamException("ads.getStatus()");

        return adsRepository.save(adRequest);
    }

    @Override
    public List<AdsInfo> listAds() {
        return adsRepository.findAll().stream()
                .map(AdsInfo::new)
                .collect(Collectors.toList());
    }

    @Override
    public Ads getAdsById(Long id) {
        return adsRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        adsRepository.deleteById(id);
    }


}
