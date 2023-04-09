package com.thesis.offer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = OfferServiceApplication.class)
@ActiveProfiles("test")
public class OfferServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
