package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    /*
        12 -> 3*4
        11 -> 3*3 + 2
        10 ->

        starts with 0, return

     */
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        if(s.length()<4 || s.length() > 12){
            return list;
        }
        backtrack(s, 0, "", 1);
        return list;
    }

    private void backtrack(String s, int currPos, String ip, int currLevel){
        if(currLevel == 5){
            if(currPos == s.length()){
                list.add(ip);
                return;
            }
        }
        if(s.length() - currPos > (5-currLevel) * 3){
            return;
        }
        for(int i=1; i<=3; i++){
            if(currPos >=s.length() ||  currPos + i > s.length()){
                return;
            }
            if(i!=1 && s.charAt(currPos) == '0'){
                return;
            }
            String tmp = s.substring(currPos, currPos + i);
            int tmpInt = Integer.valueOf(tmp);
            if(tmpInt >255){
                return;
            }
            String tmpIp = "";
            if(currPos == 0){
                tmpIp = tmp;
            } else {
                tmpIp = ip + "." + tmp;
            }
            backtrack(s, currPos +i, tmpIp, currLevel+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("2525511135").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("2520551135").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("3333").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("313323").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("10101010").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("0000").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("11011").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("1000").toArray()));
        System.out.println(Arrays.toString(new RestoreIPAddresses().restoreIpAddresses("0001").toArray()));
    }
}
