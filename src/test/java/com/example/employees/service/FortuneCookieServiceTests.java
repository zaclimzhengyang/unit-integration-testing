package com.example.employees.service;

import org.junit.Assert;
import org.junit.Test;

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
