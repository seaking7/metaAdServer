package dev.practice.ad.domain.api;

import java.util.List;

public interface AdRequestService {

    AdInitInfo processInit(AdInitCommand adInitCommand);

    AdRequestInfo requestAd(AdRequestCommand adRequestCommand);
}
