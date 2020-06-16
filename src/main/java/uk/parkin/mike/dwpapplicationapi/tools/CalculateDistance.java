package uk.parkin.mike.dwpapplicationapi.tools;

public class CalculateDistance {

    public static double getDistanceFromLondon(final double latitude, final double longitude){

        double londonLatitude = 51.509865;
        double londonLongitude = -0.118092;

        double distance = Math.sin(Math.toRadians(londonLatitude)) * Math.sin(Math.toRadians(latitude)) +
                Math.cos(Math.toRadians(londonLatitude)) * Math.cos(Math.toRadians(latitude)) *
                        Math.cos(Math.toRadians(londonLongitude - longitude));

        distance = Math.acos(distance);
        distance = Math.toDegrees(distance);
        distance = distance * 60 * 1.1515;

        return distance;
    }




}
