package dev.practice.ad.domain.app;

import dev.practice.ad.domain.ad.AdRequestInfo;

public interface AppService {
    AppInfo registerApp(AppCommand command);
}
