package dev.practice.ad.domain.ads;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdsType {
    IMAGE("이미지"), VIDEO("동영상");
    private final String description;
}
