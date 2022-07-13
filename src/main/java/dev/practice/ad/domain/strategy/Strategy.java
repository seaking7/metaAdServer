package dev.practice.ad.domain.strategy;

import dev.practice.ad.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "m_strategy")
public class Strategy extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String measuringScreenAreaX;
    private String measuringScreenAreaY;
    private String measuringScreenAreaWidth;
    private String measuringScreenAreaHeight;
    private String maxMeasuringCount;
    private String measuringInterval;
    private String waitingInterval;
    private String viewableTimeImage;
    private String viewableTimeVideo;

    @Builder
    public Strategy(String measuringScreenAreaX,
                    String measuringScreenAreaY,
                    String measuringScreenAreaWidth,
                    String measuringScreenAreaHeight,
                    String maxMeasuringCount,
                    String measuringInterval,
                    String waitingInterval,
                    String viewableTimeImage,
                    String viewableTimeVideo) {
//        if (StringUtils.isEmpty(appId)) throw new InvalidParamException("empty appId");
        this.measuringScreenAreaX = measuringScreenAreaX;
        this.measuringScreenAreaY = measuringScreenAreaY;
        this.measuringScreenAreaWidth = measuringScreenAreaWidth;
        this.measuringScreenAreaHeight = measuringScreenAreaHeight;
        this.maxMeasuringCount = maxMeasuringCount;
        this.measuringInterval = measuringInterval;
        this.waitingInterval = waitingInterval;
        this.viewableTimeImage = viewableTimeImage;
        this.viewableTimeVideo = viewableTimeVideo;


    }

}
