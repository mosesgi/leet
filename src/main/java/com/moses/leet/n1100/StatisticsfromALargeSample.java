package com.moses.leet.n1100;

import java.util.ArrayList;
import java.util.List;

public class StatisticsfromALargeSample {
    public double[] sampleStats(int[] count) {
        double min = -1d, max = 0d;
        int most = 0;
        long sum = 0, cnt = 0;
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<count.length; i++){
            if(count[i] == 0){
                continue;
            }
            if(min == -1d){
                min = (double)i;
            }
            max = Math.max(max, i);
            if(count[i] > count[most]){
                most = i;
            }
            sum += i * count[i];
            cnt+=count[i];
            l.add(i);
        }
        double median = 0d;
        boolean isEven = cnt%2==0;
        long m = cnt/2;
        long tmp = 0;
        if(isEven){
            Integer leftM = null, rightM = null;
            for(int i=0; i<count.length; i++){
                if(count[i] == 0){
                    continue;
                }
                tmp += count[i];
                if(leftM == null){
                    if(tmp > m) {
                        leftM = i;
                        rightM = i;
                        break;
                    }else if(tmp == m){
                        leftM = i;
                    }
                }else{
                    rightM = i;
                }
            }
            median = (leftM + rightM) /2d;
        }else{
            m++;
            for(int i=0; i<count.length; i++) {
                if (count[i] == 0) {
                    continue;
                }
                tmp += count[i];
                if(tmp >= m){
                    median = i;
                    break;
                }
            }
        }

        double mean = (double)(sum/cnt);
        return new double[]{min, max, mean, median, most};
    }
}
