package com.moses.leet.n1360;

public class NumberOfDaysBetweenTwoDates {
    int[] m = new int[]{-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] mL = new int[]{-1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(days(date1) - days(date2));
    }

    int days(String date){
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int total = 0;
        for(int i=1970; i<year; i++){
            if(isLeap(i)){
                total += 366;
            }else{
                total += 365;
            }
        }

        boolean isLeap = isLeap(year);
        for(int i=1; i<month; i++){
            total += isLeap?mL[i]:m[i];
        }

        total += day;
        return total;
    }

    boolean isLeap(int year){
        return year%4==0 && year%100!=0 || year%400 == 0;
    }
}
