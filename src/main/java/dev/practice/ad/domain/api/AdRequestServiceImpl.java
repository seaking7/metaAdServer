package dev.practice.ad.domain.api;

import dev.practice.ad.common.util.TokenGenerator;
import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsStore;
import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.domain.strategy.StrategyStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestServiceImpl implements AdRequestService {

    private final StrategyStore strategyStore;
    private final AdsStore adsStore;
    private static final int INIT_TOKEN_LENGTH = 40;
    private static int adSeqNum = 1;

    @Override
    public AdInitInfo processInit(AdInitCommand adInitCommand) {
        StrategyInfo strategyInfo = strategyStore.listStrategy();

        AdInitInfo adInitInfo = new AdInitInfo();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.map(strategyInfo, adInitInfo);

        adInitInfo.setToken(TokenGenerator.randomCharacter(INIT_TOKEN_LENGTH));
        if(adInitCommand.getUuid() == null || adInitCommand.getUuid().isBlank()){
            adInitInfo.setUuid(UUID.randomUUID().toString());
        } else{
            adInitInfo.setUuid(adInitCommand.getUuid());
        }

        return adInitInfo;
    }

    @Override
    public AdRequestInfo requestAd(AdRequestCommand adRequestCommand) {
        log.info(" --requestAd : {}", adRequestCommand.toString());

        Iterable<Ads> ads = adsStore.findAds(adRequestCommand.getAdsType());
        List<AdRequestInfo> resultList = mapAdsToAdRequestInfo(ads);


        AdRequestInfo result = getRandomAdRequestInfo(resultList);
        String adsSeq = getSeqString(adRequestCommand);
        result.setAdsSeq(adsSeq);
        return result;
    }

    private List<AdRequestInfo> mapAdsToAdRequestInfo(Iterable<Ads> ads) {
        List<AdRequestInfo> resultList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AdRequestInfo adRequestInfo = new AdRequestInfo();
        for (Ads ad : ads) {
            mapper.map(ad, adRequestInfo);
            log.info("----map---{}", adRequestInfo.toString());
            resultList.add(adRequestInfo);
        }
        return resultList;
    }

    private AdRequestInfo getRandomAdRequestInfo(List<AdRequestInfo> resultList) {
        Random rand = new Random();
        AdRequestInfo result = resultList.get(rand.nextInt(resultList.size()));
        return result;
    }

    private String getSeqString(AdRequestCommand adRequestCommand) {
        String adsSeq  = "";
        LocalDateTime curTime = LocalDateTime.now();
        for(int i = 0; i < adRequestCommand.getDuplicatedNum(); i++){
            String newAdSeq = curTime.format(DateTimeFormatter.ofPattern("yyyyMMddhhmm")) + String.format("%05d", adSeqNum++);
            if(!adsSeq.isBlank()) adsSeq += ",";
            adsSeq += newAdSeq;
        }
        checkAdSeqForReset();
        return adsSeq;
    }

    private synchronized void checkAdSeqForReset() {
        if(adSeqNum > 90000) adSeqNum = 1;  //seq를 5자리만 표기하므로 리셋필요
    }
}
