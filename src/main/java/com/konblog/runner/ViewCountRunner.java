package com.konblog.runner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ViewCountRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        // Reserved for Redis view-count sync warm-up
    }
}