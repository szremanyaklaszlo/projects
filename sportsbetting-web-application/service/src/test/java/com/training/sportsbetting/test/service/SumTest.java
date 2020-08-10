package com.training.sportsbetting.test.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.training.sportsbetting.service.Sum;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Sum.class)
public class SumTest {
    
    @Autowired
    private Sum sum;

//    @BeforeEach
//    public void setUp() throws Exception {
//        sum = new Sum();
//    }
//    
    @Test
    public void sumTwoNumberShouldReturnTheSumWhenGetTwoInt() throws Exception  {
        //Given
        int a = 5;
        int b = 10;
        //When
        int result = sum.sumTwoNumber(a, b);
        //Then
        assertEquals(15, result);
    }
    
    @Test
    public void sumTwoNumberShouldReturnTheSumWhenGetTwoInt2() throws Exception  {
        //Given
        int a = 5;
        int b = 10;
        //When
        int result = sum.sumTwoNumber(a, b);
        //Then
        assertEquals(15, result);
    }
}
