package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(String s, int pos, List<String> list, List<String> result){
        if(pos == s.length()){
            if(list.size() == 4){
                result.add(join(list));
            }
            return;
        }

        if(list.size() > 4){
            return;
        }
        for(int i=pos; i<pos+3 && i<s.length(); i++){
            if(s.charAt(pos) == '0' && i>pos){
                continue;
            }
            String str = s.substring(pos, i+1);
            int tmp = Integer.parseInt(str);
            if(tmp <= 255){
                list.add(str);
                backtrack(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    String join(List<String> list){
        StringBuilder sb = new StringBuilder(0);
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            if(i==0){
                sb.append(str);
            }else{
                sb.append(".").append(str);
            }
        }
        return sb.toString();
    }


    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        back(s, 0, 0, "", res);
        return res;
    }

    void back(String s, int pos, int level, String c, List<String> res){
        if(pos == s.length() && level == 4){
            res.add(c.substring(0, c.length()-1));
            return;
        }
        if(level >= 4){
            return;
        }
        for(int i=pos; i<=pos+3 && i<s.length(); i++){
            String str = s.substring(pos, i+1);
            if(str.length() > 1 && str.charAt(0) == '0'){
                continue;
            }
            int tmp = Integer.valueOf(str);
            if(tmp > 255){
                return;
            }
            back(s, i+1, level+1, c+str+".", res);
        }
    }

    /*
        12 -> 3*4
        11 -> 3*3 + 2
        10 ->

        starts with 0, return

     */
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddressesOld(String s) {

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
