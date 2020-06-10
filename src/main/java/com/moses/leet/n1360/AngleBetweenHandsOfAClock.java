package com.moses.leet.n1360;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        int perHour = 30;
        int perMin = 6;

        double hourIncPerMin = 0.5d;

        int minAng = perMin * minutes;
        double hourAng = hour*perHour + minutes * hourIncPerMin;
        double cand =  Math.abs(minAng-hourAng);
        return Math.min(cand, 360-cand);
    }
}
