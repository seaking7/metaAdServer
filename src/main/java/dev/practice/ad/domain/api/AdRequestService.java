package dev.practice.ad.domain.api;

public interface AdRequestService {

    AdInitInfo processInit(AdInitCommand adInitCommand);
}
