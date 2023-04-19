package com.example.employees.config;

import com.example.employees.controller.AreaController;
import com.example.employees.service.CalculateArea;
import com.example.employees.service.CircleService;
import com.example.employees.service.RectangleService;
import com.example.employees.service.SquareService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    /**
     * https://www.toptal.com/java/unit-integration-junit-tests
     *
     * @return
     */

    @Bean
    public AreaController areaController()
    {
        return new AreaController();
    }
    @Bean
    public CalculateArea calculateArea()
    {
        return new CalculateArea(squareService(), rectangleService(), circleService());
    }

    @Bean
    public RectangleService rectangleService()
    {
        return new RectangleService();
    }

    @Bean
    public SquareService squareService()
    {
        return new SquareService();
    }

    @Bean
    public CircleService circleService()
    {
        return new CircleService();
    }
}

