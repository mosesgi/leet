package com.moses.leet.n0420;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrongPasswordChecker {

    //WRONG!
    public int strongPasswordChecker(String s) {
        int len = s.length();
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        int addOrReplaceOrDelete = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!lower && c>='a' && c<='z'){
                lower = true;
            }
            if(!upper && c>='A' && c<='Z'){
                upper = true;
            }
            if(!digit && c>='0' && c<='9'){
                digit = true;
            }
            int tmp = 1;
            while(i+1<len && s.charAt(i+1) == c){
                i++;
                tmp++;
            }
            if(tmp >= 3){
                addOrReplaceOrDelete += (tmp/3);
            }
        }

        int addOrReplace = 0;
        if(!lower){
            addOrReplace++;
        }
        if(!upper){
            addOrReplace++;
        }
        if(!digit){
            addOrReplace++;
        }

        Integer[][] dp;
        if(len < 6){
            dp = new Integer[7][7];
        } else {
            dp = new Integer[len + 1][len + 1];
        }
        return recursive(addOrReplace, addOrReplaceOrDelete, len, dp);
    }

    private int recursive(int addOrReplace, int addOrReplaceOrDelete, int len, Integer[][] dp) {
        if(addOrReplace == 0 && addOrReplaceOrDelete == 0){
            if(len>=6 && len<=20){
                return 0;
            } else if(len < 6){
                return 6-len;
            } else {
                return 20-len;
            }
        }
        if(dp[addOrReplace][addOrReplaceOrDelete] != null){
            return dp[addOrReplace][addOrReplaceOrDelete];
        }
        //ADD
        int addStep = Integer.MAX_VALUE;
        if(addOrReplace > 0 && addOrReplaceOrDelete > 0) {
            int next = recursive(addOrReplace - 1, addOrReplaceOrDelete - 1, len + 1, dp);
            if(next != Integer.MAX_VALUE){
                addStep = 1+next;
            }
        }else if(addOrReplace > 0){
            int next = recursive(addOrReplace - 1, addOrReplaceOrDelete, len + 1, dp);
            if(next != Integer.MAX_VALUE){
                addStep = 1+next;
            }
        }else {
            int next = recursive(addOrReplace, addOrReplaceOrDelete - 1, len + 1, dp);
            if(next != Integer.MAX_VALUE){
                addStep = 1+next;
            }
        }
        //REPLACE
        int replaceStep = Integer.MAX_VALUE;
        if(addOrReplace > 0 && addOrReplaceOrDelete > 0) {
            int next = recursive(addOrReplace - 1, addOrReplaceOrDelete - 1, len, dp);
            if(next != Integer.MAX_VALUE){
                replaceStep = 1 +next;
            }
        }else if(addOrReplace > 0){
            int next = recursive(addOrReplace - 1, addOrReplaceOrDelete, len + 1, dp);
            if(next != Integer.MAX_VALUE){
                replaceStep = 1+next;
            }
        }else {
            int next = recursive(addOrReplace, addOrReplaceOrDelete - 1, len + 1, dp);
            if(next != Integer.MAX_VALUE){
                replaceStep = 1+next;
            }
        }
        //DELETE
        int deleteStep = Integer.MAX_VALUE;
        if(addOrReplaceOrDelete > 0) {
            int next = recursive(addOrReplace, addOrReplaceOrDelete - 1, len, dp);
            if(next != Integer.MAX_VALUE){
                deleteStep = 1 + next;
            }
        }
        int min = Math.min(Math.min(addStep, replaceStep), deleteStep);
        dp[addOrReplace][addOrReplaceOrDelete] = min;
        return min;
    }

    public static void main(String[] args) {
        String s;
        s = "";
        System.out.println(new StrongPasswordChecker().strongPasswordChecker(s));

        s = "aad";
        System.out.println(new StrongPasswordChecker().strongPasswordChecker(s));
    }
}
