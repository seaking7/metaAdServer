package dev.practice.ad.infrastructure.app;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.app.App;

import dev.practice.ad.domain.app.AppStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppStoreImpl implements AppStore {

    private final AppRepository appRepository;

    @Override
    public App store(App app) {
        if (StringUtils.isEmpty(app.getAppId())) throw new InvalidParamException("app.getAppId()");
        if (app.getStatus() == null) throw new InvalidParamException("app.getStatus()");

        return appRepository.save(app);
    }

}
