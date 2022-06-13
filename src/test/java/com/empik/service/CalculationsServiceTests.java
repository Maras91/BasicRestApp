package com.empik.service;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationsServiceTests {

    @Test
    public void calculateSimpleTestOne() {
        //given
        CalculationsService calculationsService = new CalculationsService();
        double followers = 6;
        double publicRepos = 1;
        double result;
        //when
        result = calculationsService.calculate(followers,publicRepos);
        //then
        assertEquals(3, result, 0.0);
    }

    @Test
    public void calculateSimpleTestTwo() {
        //given
        CalculationsService calculationsService = new CalculationsService();
        double followers = 3;
        double publicRepos = 2;
        double result;
        //when
        result = calculationsService.calculate(followers,publicRepos);
        //then
        assertEquals(8, result, 0.0);
    }

    @Test
    public void calculateDivisionByZeroTest() {
        //given
        CalculationsService calculationsService = new CalculationsService();
        double followers = 0;
        double publicRepos = 1;
        Double result;
        //when
        result = calculationsService.calculate(followers,publicRepos);
        //then
        assertNull(result);
    }
}
