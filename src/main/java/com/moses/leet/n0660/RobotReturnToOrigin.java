package com.moses.leet.n0660;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] cnt = new int[4];
        for(char c : moves.toCharArray()){
            if(c=='U'){
                cnt[0]++;
            }else if(c=='D'){
                cnt[1]++;
            }else if(c=='L'){
                cnt[2]++;
            }else{
                cnt[3]++;
            }
        }
        return cnt[0] == cnt[1] && cnt[2] == cnt[3];
    }
}
