package com.example.employees.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PartialMockingWithSpy {

    @Spy
    RectangleService rectangleService;
    @Mock
    SquareService squareService;
    @Mock
    CircleService circleService;

    @InjectMocks
    CalculateArea calculateArea;

    @Test
    public void calculateRectangleAreaTest()
    {
        Mockito.doCallRealMethod().when(rectangleService).log();
        Mockito.when(rectangleService.area(5.0d,4.0d)).thenReturn(20d);

        Double calculatedArea = this.calculateArea.calculateArea(Type.RECTANGLE, 5.0d, 4.0d);
        Assert.assertEquals(new Double(20d),calculatedArea);
    }
}
