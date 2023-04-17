package com.example.employees.service;

import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class EffectfulVsNonEffectfulService {
    /**
     * This is a dummy server which explains the difference between effectful and non effectful methods
     *
     * Rule of thumb:
     * - If you have a high level method that consists of both effectful and non effectful logic
     *
     * Separate them into their separate methods, one or more for pure calculations, one or more for effectful methods
     */

    public HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

    // This doesn't fully work, as we havent provided the connection string etc
    public JdbcTemplate httpTemplate = new JdbcTemplate();

    // This doesn't fully work, as we havent provided the connection string etc
    public RestTemplate restTemplate = new RestTemplate();

    public void effectfulMethodOne(Integer someNumber) {
        /**
         * An effectful method which increments the count of an integer in the countMap
         *
         * This is effectful, because it changes the state of a variable
         */
        this.countMap.put(someNumber, this.countMap.getOrDefault(someNumber, 0) + 1);
    }

    public void effectfulMethodTwo(Integer someNumber) {
        /**
         * An effectful method which prints to your console
         *
         * This is effectful, because it changes the state of your console
         *
         * Logging counts as effectful as well
         */
        System.out.println(10);
    }

    public void effectfulMethodThree(String cookie) {
        /**
         * An effectful method which makes a database request
         *
         * This is effectful, because it changes the state of your database
         *
         * A query is also considered effectful
         *
         */
        httpTemplate.execute(String.format("INSERT INTO COOKIE (cookie) VALUES (%s)", cookie));
    }

    public void effectfulMethodFourth(String cookie) {
        /**
         * An effectful method which sends an API request to another server
         *
         * This is effectful, because it changes the state of the other server
         *
         * A API query (GET) is also considered effectful
         *
         */
        restTemplate.execute("http://localhost:5000", HttpMethod.GET, null, null);
    }

    public Integer nonEffectfulMethodOne(Integer a, Integer b) {
        /**
         * An non-effectful method which returns the product of a and b
         *
         * notice that there are no state change here; specifically even variable changes
         */
        return a * b;
    }
}
