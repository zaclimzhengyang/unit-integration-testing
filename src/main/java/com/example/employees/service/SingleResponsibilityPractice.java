package com.example.employees.service;

import java.util.HashMap;

public class SingleResponsibilityPractice {
    /**
     * SOLID principles
     *
     * S -> Single Responsibility
     *
     * We do our best to make methods and classes have one responsibility
     */

    public HashMap<String, Integer> cookiesToCountDatabase = new HashMap<String, Integer>();

    public String getCookieWithName(String name) {
        /**
         * Get a random cookie from the database
         *
         * random cookie: "Drinking Caffeine in the morning is the best"
         *
         * expected result: "Zheng Yang, Drinking Caffeine in the morning is the best"
         *
         * This method can be split into two logic here
         * 1. (Effectful) One to call the database to get a cookie
         * 2. (Pure) Concat the name with the cookie
         *
         * Tip: When you have a high-level method that calls multiple functions (be they effectful or not)
         * and we want to create a unit test for this
         *
         * Reminder: A unit test should only fail, if there is a bug in that method
         * It shouldn't fail, even if the lower-level methods have a bug
         * (we use Mockito here to mock the result of lower-level methods, assume these methods are already correct)
         *
         * Scenario 1 where Mockito is very useful:
         * 1. It allows us to mock the expected behaviour of lower-level methods
         * - This ensures the test wont fail, even if the lower level methods have a bug
         *
         * We should mock getCookieFromDatabase, concatCookieWithCookie and concatNameWithCookie
         *
         * 2. It allows us to test the logic of the high level method without needing a server / database
         * - especially if the method requires them
         *
         * The method we are mocking here is getCookieFromDatabase (assume its making an SQL query)
         *
         */
        String cookieOne = getCookieFromDatabase();
        String cookieTwo = getCookieFromDatabase();
        // Notice that this high-level method has two pure logic
        // We want to ensure this high-level method does these two pure logic in the correct order
        String concatCookies = concatCookieWithCookie(cookieOne, cookieTwo);
        String result = concatNameWithCookie(name, concatCookies);
        return result;
    }

    public String getCookieFromDatabase() {
        /**
         * Iterate through all random cookies, and get one
         *
         * By right we should randomly get a cookie, but for the sake of this demo,
         * we just return a static cookie
         */
        String cookie = "Cookie is the best";
        this.cookiesToCountDatabase.put(cookie, this.cookiesToCountDatabase.getOrDefault(cookie, 1) - 1);
        return cookie;
    }

    public String concatNameWithCookie(String name, String cookie) {
        return String.format("%s, %s", name, cookie);
    }

    public String concatCookieWithCookie(String cookieOne, String cookieTwo) {
        return String.format("Cookie 1: %s, Cookie 2: %s", cookieOne, cookieTwo);
//        return String.format("%s, %s", cookieOne, cookieTwo);

    }

    public static void main(String[] args) {
        SingleResponsibilityPractice service = new SingleResponsibilityPractice();

        System.out.println(service.getCookieWithName("Clement"));
    }


}
