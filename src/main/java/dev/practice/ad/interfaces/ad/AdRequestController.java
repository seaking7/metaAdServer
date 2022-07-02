package dev.practice.ad.interfaces.ad;

import dev.practice.ad.application.ad.AdRequestFacade;
import dev.practice.ad.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class AdRequestController {
    private final AdRequestFacade adRequestFacade;

    @PostMapping
    public CommonResponse registerPartner(@RequestBody @Valid AdRequestDto.RegisterRequest request) {
        var command = request.toCommand();
        var adRequestInfo = adRequestFacade.registerPartner(command);
        var response = new AdRequestDto.RegisterResponse(adRequestInfo);
        return CommonResponse.success(response);
    }
}
