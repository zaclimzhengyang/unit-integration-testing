package com.example.employees.controller;

import com.example.employees.service.CalculateArea;
import com.example.employees.service.Type;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)

public class AreaControllerTest {

    @Mock
    CalculateArea calculateArea;

    @InjectMocks
    AreaController areaController;

    @Test
    public void calculateAreaTest()
    {
        Mockito
                .when(calculateArea.calculateArea(Type.RECTANGLE,5.0d, 4.0d))
                .thenReturn(20d);

        ResponseEntity responseEntity = areaController.calculateArea("RECTANGLE", "5", "4");
        Assert.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assert.assertEquals(20d,responseEntity.getBody());
    }

}