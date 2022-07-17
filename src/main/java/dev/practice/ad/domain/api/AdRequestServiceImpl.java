package dev.practice.ad.domain.api;

import dev.practice.ad.common.util.TokenGenerator;
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
    private static final int INIT_TOKEN_LENGTH = 40;

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
}
