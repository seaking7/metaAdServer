package dev.practice.ad.domain.api;

public interface AdRequestService {

    AdRequestInfo processInit(AdInitCommand adInitCommand);
}
