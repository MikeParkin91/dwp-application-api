package uk.parkin.mike.dwpapplicationapi.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDistanceTest {

    @Test
    public void testGetDistanceFromLondon() {
        double newcastleLatitude = 54.9732819;
        double newcastleLongitude = -1.61396;
        long expectedResult = 247;
        long actualResult = Math.round(CalculateDistance.getDistanceFromLondon(newcastleLatitude, newcastleLongitude));

        assertEquals(expectedResult, actualResult);
    }
}