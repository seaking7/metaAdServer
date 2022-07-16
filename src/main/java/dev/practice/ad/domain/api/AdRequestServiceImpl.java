package dev.practice.ad.domain.api;

import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.domain.strategy.StrategyStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestServiceImpl implements AdRequestService {

    private final StrategyStore strategyStore;

    @Override
    public AdRequestInfo processInit(AdInitCommand adInitCommand) {
        StrategyInfo strategyInfo = strategyStore.listStrategy();

        AdRequestInfo adRequestInfo = new AdRequestInfo();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.map(strategyInfo, adRequestInfo);

        if(adInitCommand.getUuid() == null || adInitCommand.getUuid().isBlank()){
            adRequestInfo.setUuid(UUID.randomUUID().toString());
        } else{
            adRequestInfo.setUuid(adInitCommand.getUuid());
        }

        return adRequestInfo;
    }
}
