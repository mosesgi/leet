package com.moses.leet.n0960;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int max = -1;
        int h1 = 0, h2 = 0, m1 = 0, m2 = 0;
        int rh = -1, rm = -1;
        for(int i=0; i<A.length; i++){
            h1 = A[i];
            for(int j=0; j<A.length; j++){
                if(i==j){
                    continue;
                }
                h2 = A[j];
                int hours = h1 * 10 + h2;
                if(hours < 0 || hours >= 24){
                    continue;
                }
                for(int k=0; k<A.length; k++){
                    if(k==i || k==j){
                        continue;
                    }
                    m1 = A[k];
                    for(int m = 0; m<A.length; m++){
                        if(m==i || m==j || m==k){
                            continue;
                        }
                        m2 = A[m];
                        int mins = m1 * 10 + m2;
                        if(mins < 0 || mins >59){
                            continue;
                        }
                        int tmp = hours * 60 + mins;
                        if(tmp > max){
                            max = tmp;
                            rh = hours;
                            rm = mins;
                        }
                    }
                }
            }
        }
        if(rh == -1 && rm == -1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(rh < 10){
            sb.append("0");
        }
        sb.append(rh).append(":");
        if(rm < 10){
            sb.append("0");
        }
        sb.append(rm);
        return sb.toString();
    }
}
