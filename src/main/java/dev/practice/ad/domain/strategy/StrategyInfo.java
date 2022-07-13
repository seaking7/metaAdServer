package dev.practice.ad.domain.strategy;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class StrategyInfo {
    private String measuringScreenAreaX;
    private String measuringScreenAreaY;
    private String measuringScreenAreaWidth;
    private String measuringScreenAreaHeight;
    private String maxMeasuringCount;
    private String measuringInterval;
    private String waitingInterval;
    private String viewableTimeImage;
    private String viewableTimeVideo;
    private LocalDateTime updatedAt;

    public StrategyInfo(){
    }

    public StrategyInfo(Strategy strategy){
        this.measuringScreenAreaX = strategy.getMeasuringScreenAreaX();
        this.measuringScreenAreaY = strategy.getMeasuringScreenAreaY();
        this.measuringScreenAreaWidth = strategy.getMeasuringScreenAreaWidth();
        this.measuringScreenAreaHeight = strategy.getMeasuringScreenAreaHeight();
        this.maxMeasuringCount = strategy.getMaxMeasuringCount();
        this.measuringInterval = strategy.getMeasuringInterval();
        this.waitingInterval = strategy.getWaitingInterval();
        this.viewableTimeImage = strategy.getViewableTimeImage();
        this.viewableTimeVideo = strategy.getViewableTimeVideo();
        this.updatedAt = strategy.getUpdatedAt().toLocalDateTime();
    }

}
