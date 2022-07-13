package dev.practice.ad.infrastructure.strategy;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.app.App;
import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.domain.app.AppStore;
import dev.practice.ad.domain.strategy.Strategy;
import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.domain.strategy.StrategyStore;
import dev.practice.ad.infrastructure.app.AppRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class StrategyStoreImpl implements StrategyStore {

    private final StrategyRepository strategyRepository;


    @Override
    public Strategy upsert(Strategy strategy) {
//        if (StringUtils.isEmpty(app.getAppId())) throw new InvalidParamException("app.getAppId()");
//        if (app.getStatus() == null) throw new InvalidParamException("app.getStatus()");
        Strategy saved = strategyRepository.findAll().stream().findFirst().orElse(new Strategy());
        saved.setMeasuringScreenAreaX(strategy.getMeasuringScreenAreaX());
        saved.setMeasuringScreenAreaY(strategy.getMeasuringScreenAreaY());
        saved.setMeasuringScreenAreaWidth(strategy.getMeasuringScreenAreaWidth());
        saved.setMeasuringScreenAreaHeight(strategy.getMeasuringScreenAreaHeight());
        saved.setMaxMeasuringCount(strategy.getMaxMeasuringCount());
        saved.setMeasuringInterval(strategy.getMeasuringInterval());

        return strategyRepository.save(saved);
    }

    @Override
    public Optional<StrategyInfo> listStrategy() {
        return strategyRepository.findAll()
                .stream()
                .map(StrategyInfo::new)
                .findFirst();


    }
}
