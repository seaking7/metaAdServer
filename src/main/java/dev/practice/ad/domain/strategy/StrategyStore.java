package dev.practice.ad.domain.strategy;


import java.util.Optional;

public interface StrategyStore {
    Strategy upsert(Strategy strategy);

    Optional<StrategyInfo> listStrategy();
}
