package com.moses.leet.n0480;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateIpAddress {
    static String invalid =  "Neither";
    static String IPv4 = "IPv4";
    static String IPv6 = "IPv6";

    public String validIPAddress(String IP) {
        if(IP.contains(".")){
            if(IP.contains(":") || IP.endsWith(".")){
                return invalid;
            }
            String[] strs = IP.split("\\.");
            if(strs.length!= 4){
                return invalid;
            }
            for(String s: strs){
                if(s.equals("0")){
                    continue;
                }
                if(s.length() == 0 || s.startsWith("0") || s.length() >3){
                    return invalid;
                }
                for(char c : s.toCharArray()){
                    if(!Character.isDigit(c)){
                        return invalid;
                    }
                }
                int curr = Integer.parseInt(s);
                if(curr>255){
                    return invalid;
                }
            }
            return IPv4;
        }

        if(IP.endsWith(":")){
            return invalid;
        }
        String[] strs = IP.split(":");
        if(strs.length != 8){
            return invalid;
        }
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'));
        for(String s: strs){
            if(s.length() == 0 || s.length()>4){
                return invalid;
            }
            s = s.toLowerCase();
            for(char c : s.toCharArray()){
                if(!set.contains(c)){
                    return invalid;
                }
            }
        }
        return IPv6;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIpAddress().validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:733a"));
        System.out.println(new ValidateIpAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(new ValidateIpAddress().validIPAddress("172.16.254.1."));
        System.out.println(new ValidateIpAddress().validIPAddress("172.16.254.1"));
        System.out.println(new ValidateIpAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(new ValidateIpAddress().validIPAddress("256.256.256.256"));
    }
}
