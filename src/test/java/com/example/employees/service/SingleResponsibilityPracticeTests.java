package com.example.employees.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SingleResponsibilityPracticeTests {
    @Spy
    private SingleResponsibilityPractice singleResponsibilityPractice;

    @Before
    public void setup() {
        // we got do this to allow the Spy object to be mocked
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFortuneCookieServiceGetCookie() {
        /**
         * This unit test is to test the concatCookieWithCookie of SingleResponsibilityPractice class
         *
         * to ascertain whether it is returning the intended statement indicating the 2 cookies
         */

        String obtainedCookie = FortuneCookieService.getCookie();
        String expectedCookie = "Being Hangry is bad";
        Assert.assertEquals(expectedCookie, obtainedCookie);
    }

    @Test
    public void testGetCookieFromDatabase() {
        String obtainedCookie = singleResponsibilityPractice.getCookieFromDatabase();
        String expectedCookie = "Cookie is the best";
        Assert.assertEquals(expectedCookie, obtainedCookie);
    }

    @Test
    public void testConcatNameWithCookie() {
        String obtainedNameWithCookie = singleResponsibilityPractice.concatNameWithCookie("ZY", "Golden Cookie");
        String expectedNameWithCookie = "ZY, Golden Cookie";
        Assert.assertEquals(expectedNameWithCookie, obtainedNameWithCookie);
    }

    @Test
    public void testConcatCookieWithCookie() {
        String obtainedConcatCookie = singleResponsibilityPractice.concatCookieWithCookie("Brown Cookie", "Blue Cookie");
        String expectedCookie = "Cookie 1: Brown Cookie, Cookie 2: Blue Cookie";
        Assert.assertEquals(expectedCookie, obtainedConcatCookie);
    }

    @Test
    public void testGetCookieWithName() {
        /**
         *
         * When we are testing the higher level method getCookieFromDatabase
         * Given "Clement"
         *
         * Cookie 1:
         */
        String mockedCookie = "Golden Cookie";
        String mockedConcatCookie = String.format("Cookie 1: %s, Cookie 2: %s", mockedCookie, mockedCookie);
        String mockName = "Clement";
        String mockedConcatNameWithCookie = String.format("%s, Cookie 1: %s, Cookie 2: %s", mockName, mockedCookie, mockedCookie);

        Mockito.when(this.singleResponsibilityPractice.getCookieFromDatabase()).thenReturn(mockedCookie);
        Mockito.when(this.singleResponsibilityPractice.concatCookieWithCookie(mockedCookie, mockedCookie)).thenReturn(mockedConcatCookie);
        Mockito.when(this.singleResponsibilityPractice.concatNameWithCookie(mockName, mockedConcatCookie)).thenReturn(mockedConcatNameWithCookie);

        String obtainedCookie = this.singleResponsibilityPractice.getCookieWithName(mockName);

        Assert.assertEquals(obtainedCookie, mockedConcatNameWithCookie);
    }
}
