package dev.practice.ad.domain.strategy;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class StrategyCommand {

    private String measuringScreenAreaX;
    private String measuringScreenAreaY;
    private String measuringScreenAreaWidth;
    private String measuringScreenAreaHeight;
    private String maxMeasuringCount;
    private String measuringInterval;
    private String waitingInterval;
    private String viewableTimeImage;
    private String viewableTimeVideo;

    public Strategy toEntity() {
        return Strategy.builder()
                .measuringScreenAreaX(measuringScreenAreaX)
                .measuringScreenAreaY(measuringScreenAreaY)
                .measuringScreenAreaWidth(measuringScreenAreaWidth)
                .measuringScreenAreaHeight(measuringScreenAreaHeight)
                .maxMeasuringCount(maxMeasuringCount)
                .measuringInterval(measuringInterval)
                .waitingInterval(waitingInterval)
                .viewableTimeImage(viewableTimeImage)
                .viewableTimeVideo(viewableTimeVideo)
                .build();
    }
}
