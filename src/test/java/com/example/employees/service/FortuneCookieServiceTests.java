package com.example.employees.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

public class FortuneCookieServiceTests {

    @Test
    public void testFortuneCookieServiceGetCookie() {
        /**
         * Unit Test for FortuneCookieService.getCookie()
         *
         * The cookie returned should return "Being Hangry is bad"
         */
        String obtainedCookie = FortuneCookieService.getCookie();
        String expectedCookie = "Being Hangry is bad";
        Assert.assertEquals(expectedCookie, obtainedCookie);
    }
}
