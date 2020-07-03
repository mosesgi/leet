package com.moses.leet.study;

import java.util.Scanner;

public class StringRegex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String p = scan.nextLine();
            String str = scan.nextLine();
            System.out.println(StringRegex.dfs(p, str, 0, 0));
        }
        scan.close();
    }

    public static boolean dfs(String p, String str, int p1, int p2) {
        if(p1 == p.length() && p2 == str.length()){
            return true;
        }else if(p1 == p.length() || p2 == str.length()){
            return false;
        }
        if(p.charAt(p1) == '?'){
            return dfs(p, str, p1+1, p2+1);
        }else if(p.charAt(p1) == '*'){
            return dfs(p, str, p1+1, p2) || dfs(p, str, p1+1, p2+1) || dfs(p, str, p1, p2+1);
        }else{
            if(p.charAt(p1) == str.charAt(p2)){
                return dfs(p, str, p1+1, p2+1);
            }else{
                return false;
            }
        }
    }
}
