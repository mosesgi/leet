package com.moses.leet.study;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {

    public int compress(char[] chars) {
        int cnt = 0;
        char cur = chars[0];
        int slow = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] == cur){
                cnt++;
            }
            if(chars[i] != cur || i == chars.length-1 ){
                chars[slow++] = cur;
                if(cnt > 1){
                    String num = ""+ cnt;
                    for(char a : num.toCharArray()){
                        chars[slow++] = a;
                    }
                }
                cur = chars[i];
                cnt = 1;
            }
        }
        return slow;
    }

    public int findSubstringInWraproundString(String p) {
        Set<String> set = new HashSet<>();
        int prev = 0;
        for(int i=1; i<p.length(); i++){
            if(p.charAt(i) == (char)(p.charAt(i-1) + 1)){

            }else if(p.charAt(i) == 'a' && p.charAt(i-1) == 'z'){

            }else{
                String tmp = p.substring(prev, i);
                boolean contained = false;
                Iterator<String> iter = set.iterator();
                while(iter.hasNext()){
                    String cur = iter.next();
                    if(cur.contains(tmp)){
                        contained = true;
                        break;
                    }else if(tmp.contains(cur)){
                        iter.remove();
                    }
                }
                if(!contained){
                    set.add(tmp);
                }
                prev = i;
            }
        }
        String tmp = p.substring(prev);
        boolean contained = false;
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String cur = iter.next();
            if(cur.contains(tmp)){
                contained = true;
                break;
            }else if(tmp.contains(cur)){
                iter.remove();
            }
        }
        if(!contained){
            set.add(tmp);
        }
        int res = 0;
        for(String s : set){
            int i = s.length();
            res += i*(i+1)/2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(new Test().findSubstringInWraproundString("cac"));
        System.out.println(new Test().findSubstringInWraproundString("zaba"));

        char[] chars;
        chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new Test().compress(chars));
    }
}
