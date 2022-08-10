package dev.practice.ad.interfaces.api;

import dev.practice.ad.config.auth.CustomOAuth2UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Api 테스트")
@SpringBootTest
class AdRequestControllerTest {

    private final MockMvc mvc;

    AdRequestControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @Test
    void getInitAd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/init"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getRequestAd() {
    }

    @Test
    void getReportAd() {
    }

    @Test
    void testHeader() {
    }
}