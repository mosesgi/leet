package com.moses.leet.n0940;

import java.util.Arrays;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) ->{
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);

            boolean s1Digit = Character.isDigit(s1[1].charAt(0));
            boolean s2Digit = Character.isDigit(s2[1].charAt(0));
            if(s1Digit && !s2Digit){
                return 1;
            }else if(!s1Digit && s2Digit){
                return -1;
            }else if(s1Digit && s2Digit){
                return 0;
            }
            int comp = s1[1].compareTo(s2[1]);
            if(comp == 0){
                return s1[0].compareTo(s2[0]);
            }else{
                return comp;
            }
        });
        return logs;
    }
}
