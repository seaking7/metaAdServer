package dev.practice.ad.interfaces.web.form;

import dev.practice.ad.domain.app.AppCommand;
import dev.practice.ad.domain.strategy.StrategyCommand;
import lombok.Data;

@Data
public class StrategyForm {
    private String measuringScreenAreaX;
    private String measuringScreenAreaY;
    private String measuringScreenAreaWidth;
    private String measuringScreenAreaHeight;
    private String maxMeasuringCount;
    private String measuringInterval;
    private String waitingInterval;
    private String viewableTimeImage;
    private String viewableTimeVideo;

    public StrategyCommand toCommand(){
        return StrategyCommand.builder()
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
