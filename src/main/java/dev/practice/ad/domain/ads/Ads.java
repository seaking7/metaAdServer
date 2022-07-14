package dev.practice.ad.domain.ads;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.common.util.TokenGenerator;
import dev.practice.ad.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "m_ads")
public class Ads extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adsId;
    private String adsName;
    private String materialUrl;

    private String adsWidth;
    private String adsHeight;


    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum AdsType {
        IMAGE("이미지"), VIDEO("동영상");
        private final String description;
    }

    @Builder
    public Ads(String adsId, String adsName, String materialUrl, String adsWidth, String adsHeight) {
        if (StringUtils.isEmpty(adsId)) throw new InvalidParamException("empty adsId");

        this.adsId = adsId;
        this.adsName = adsName;
        this.materialUrl = materialUrl;
        this.adsWidth = adsWidth;
        this.adsHeight = adsHeight;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
