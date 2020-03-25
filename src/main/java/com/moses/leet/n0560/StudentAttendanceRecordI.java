package com.moses.leet.n0560;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int cntA = 0, cntL = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='L'){
                cntL++;
            }else{
                cntL=0;
                if(c=='A'){
                    cntA++;
                }
            }
            if(cntL>2 || cntA > 1){
                return false;
            }
        }
        return true;
    }
}
