package com.konblog.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViewCountRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        // Reserved for Redis view-count sync warm-up
    }
}