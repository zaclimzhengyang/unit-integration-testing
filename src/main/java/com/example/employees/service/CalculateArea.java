package com.example.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateArea {

    SquareService squareService;
    RectangleService rectangleService;
    CircleService circleService;



    public CalculateArea(@Autowired SquareService squareService, @Autowired RectangleService rectangeService, @Autowired CircleService circleService)
    {
        this.squareService = squareService;
        this.rectangleService = rectangeService;
        this.circleService = circleService;
    }

    public Double calculateArea(Type type, Double... r )
    {
        switch (type)
        {
            case RECTANGLE:
                if(r.length >=2)
                    return rectangleService.area(r[0],r[1]);
                else
                    throw new RuntimeException("Missing required params");
            case SQUARE:
                if(r.length >=1)
                    return squareService.area(r[0]);
                else
                    throw new RuntimeException("Missing required param");

            case CIRCLE:
                if(r.length >=1)
                    return circleService.area(r[0]);
                else
                    throw new RuntimeException("Missing required param");
            default:
                throw new RuntimeException("Operation not supported");
        }
    }
}
