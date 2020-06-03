package com.moses.leet.n1120;

/**
 * There are n flights, and they are labeled from 1 to n.
 *
 * We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
 *
 * Return an array answer of length n, representing the number of seats booked on each flight in order of their label.
 *
 *  
 *
 * Example 1:
 *
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 *  
 *
 * Constraints:
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 *
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] b : bookings){
            res[b[0]-1] += b[2];        //onboard
            if(b[1] < n) {
                res[b[1]] -= b[2];      //offboard
            }
        }

        for(int i=1; i<res.length; i++){
            res[i] = res[i-1]+res[i];
        }
        return res;
    }


    public int[] corpFlightBookingsSlow(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] b : bookings){
            for(int i=b[0]; i<=b[1]; i++){
                res[i-1] += b[2];
            }
        }
        return res;
    }
}
