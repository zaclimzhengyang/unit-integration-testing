package com.example.employees.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

// wrong Test module
//import org.junit.jupiter.api.Test;


public class AlternativeTest {

    public class CalculateAreaTest {

        @Mock
        RectangleService rectangleService;
        @Mock
        SquareService squareService;
        @Mock
        CircleService circleService;

        @InjectMocks
        CalculateArea calculateArea;

        @Before
        public void init()
        {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void alternativeTestMethod()
        {
            Mockito.when(rectangleService.area(5.0d,4.0d)).thenReturn(20d);
            Double calculatedArea = this.calculateArea.calculateArea(Type.RECTANGLE, 5.0d, 4.0d);
            Assert.assertEquals(new Double(20d),calculatedArea);
        }
    }
}
