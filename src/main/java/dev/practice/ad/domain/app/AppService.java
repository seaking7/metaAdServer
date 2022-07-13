package dev.practice.ad.domain.app;

import dev.practice.ad.domain.ad.AdRequestInfo;

import java.util.List;

public interface AppService {
    AppInfo registerApp(AppCommand command);

    List<AppInfo> listApp();
}
