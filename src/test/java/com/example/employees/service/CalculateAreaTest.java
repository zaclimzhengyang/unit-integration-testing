package com.example.employees.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CalculateAreaTest {

    RectangleService rectangleService;
    SquareService squareService;
    CircleService circleService;

    CalculateArea calculateArea;

    @Before
    public void init()
    {
        rectangleService = Mockito.mock(RectangleService.class);
        squareService = Mockito.mock(SquareService.class);
        circleService = Mockito.mock(CircleService.class);
        calculateArea = new CalculateArea(squareService,rectangleService,circleService);
    }

    @Test
    public void calculateRectangleAreaTest()
    /**
     *  high level function - calculateArea
     *  low level function - recentangleService.area
     *  in here, we mock the low level function to test the functionality of the high level function
     */
    {
        Mockito.when(rectangleService.area(5.0D,4.0D)).thenReturn(20D);
        Double calculatedArea = this.calculateArea.calculateArea(Type.RECTANGLE, 5.0D, 4.0D);
        Double expectedArea = 20.0;
        Assert.assertEquals(expectedArea,calculatedArea);

    }
}