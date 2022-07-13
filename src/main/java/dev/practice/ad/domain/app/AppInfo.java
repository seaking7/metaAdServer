package dev.practice.ad.domain.app;

import dev.practice.ad.domain.ad.AdRequest;
import lombok.Getter;

@Getter
public class AppInfo {
    private final Long id;
    private final String appId;
    private final String appName;
    private final String appKey;

    public AppInfo(App app){
        this.id = app.getId();
        this.appId = app.getAppId();
        this.appName = app.getAppName();
        this.appKey = app.getAppKey();
    }

}
