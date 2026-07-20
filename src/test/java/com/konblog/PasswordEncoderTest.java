package com.konblog;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderTest {

    @Test
    void bcrypt_matches() {
        var encoder = new BCryptPasswordEncoder();
        String raw = "123456";
        String hash = encoder.encode(raw);
        assertTrue(encoder.matches(raw, hash));
        assertFalse(encoder.matches("wrong", hash));
        assertTrue(hash.startsWith("$2a"));
    }

    @Test
    void bcrypt_differentHashes() {
        var encoder = new BCryptPasswordEncoder();
        String h1 = encoder.encode("123456");
        String h2 = encoder.encode("123456");
        assertNotEquals(h1, h2);
        assertTrue(encoder.matches("123456", h1));
        assertTrue(encoder.matches("123456", h2));
    }
}