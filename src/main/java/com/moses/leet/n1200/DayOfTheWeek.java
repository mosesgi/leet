package com.moses.leet.n1200;

public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] daysOfYear = new int[2200];
        int[] daysOfMonthNonLeap = new int[13];
        int[] daysOfMonthLeap = new int[13];
        String[] dayOfWeek = new String[]{"Friday","Saturday", "Sunday", "Monday", "Tuesday", "Wednesday","Thursday"};

        for(int i=0; i<daysOfYear.length; i++){
            if(i%4==0 && i%100 != 0 || i%400 == 0){
                daysOfYear[i] = 366;
            }else{
                daysOfYear[i] = 365;
            }
        }

        for(int i=1; i<=7; i++){
            daysOfMonthLeap[i] = i%2==1?31:30;
            daysOfMonthNonLeap[i] = i%2==1?31:30;
        }
        daysOfMonthLeap[2] = 29;
        daysOfMonthNonLeap[2] = 28;
        for(int i=8; i<=12; i++){
            daysOfMonthLeap[i] = i%2==0?31:30;
            daysOfMonthNonLeap[i] = i%2==0?31:30;
        }

        int baseYear = 1971, baseMonth = 1, baseDay = 1;
        int dayDiff = 0;
        while(baseYear < year){
            dayDiff += daysOfYear[baseYear++];
        }
        boolean isLeapYear = year %4==0 && year%100 != 0 || year %400 == 0;
        while(baseMonth < month){
            dayDiff += isLeapYear?daysOfMonthLeap[baseMonth++]:daysOfMonthNonLeap[baseMonth++];
        }

        dayDiff += day-1;
        System.out.println(dayDiff);

        return dayOfWeek[dayDiff%7];
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(26, 5, 2020));
        System.out.println(new DayOfTheWeek().dayOfTheWeek(3, 1, 1971));
    }
}
