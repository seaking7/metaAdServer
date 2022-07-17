package dev.practice.ad.domain.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@ToString
@XmlRootElement(name = "init")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdInitInfo {
    @XmlElement (name = "uuid")
    private String uuid;
    private String token;
    @XmlElement(name = "MeasuringScreenArea_x")
    private Integer measuringScreenAreaX;
    @XmlElement(name = "MeasuringScreenArea_y")
    private Integer measuringScreenAreaY;
    @XmlElement(name = "MeasuringScreenArea_width")
    private Integer measuringScreenAreaWidth;
    @XmlElement(name = "MeasuringScreenArea_height")
    private Integer measuringScreenAreaHeight;
    @XmlElement(name = "MaxMeasuringCount")
    private Integer maxMeasuringCount;
    @XmlElement(name = "MeasuringInterval")
    private String measuringInterval;
    @XmlElement(name = "WatingInterval")
    private String waitingInterval;
    @XmlElement(name = "ViewableTimeImage")
    private String viewableTimeImage;
    @XmlElement(name = "ViewableTimeVideo")
    private String viewableTimeVideo;
    @XmlElement(name = "VisibleArea")
    private String visibleArea;
    @XmlElement(name = "PixelGrid")
    private String pixelGrid;
    @XmlElement(name = "ReferenceScreenHandheld_x")
    private Integer referenceScreenHandheldX;
    @XmlElement(name = "ReferenceScreenHandheld_y")
    private Integer referenceScreenHandheldY;
    @XmlElement(name = "ReferenceScreenBig_x")
    private Integer referenceScreenBigX;
    @XmlElement(name = "ReferenceScreenBig_y")
    private Integer referenceScreenBigY;
    @XmlElement(name = "ScreenRelativeLength")
    private String screenRelativeLength;
    @XmlElement(name = "SkewAngle")
    private String skewAngle;
}
