package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LogTest {

    @Test
    public void testLog() {
        String testInfo = "Free flying flowers are like dreams";
        log.info("The test info is :{}", testInfo);
    }
}
