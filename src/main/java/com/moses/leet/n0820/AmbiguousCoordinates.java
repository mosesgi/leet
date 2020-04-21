package com.moses.leet.n0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length()-1);
        List<String> res = new ArrayList<>();
        for(int i=1; i<S.length(); i++){
            String left = S.substring(0, i);
            String right = S.substring(i);

            if(!checkZero(left) || !checkZero(right)){
                continue;
            }
            List<String> ls = generate(left);
            List<String> rs = generate(right);
            for(String l : ls){
                for(String r : rs){
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    List<String> generate(String s){
        if(s.length() == 1){
            return Arrays.asList(s);
        }
        if(s.charAt(0) == '0'){
            return Arrays.asList("0." + s.substring(1));
        }
        if(s.charAt(s.length()-1) == '0'){
            return Arrays.asList(s);
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        list.add(s);
        for(int i=1; i<s.length(); i++){
            sb.insert(i, ".");
            list.add(sb.toString());
            sb.deleteCharAt(i);
        }
        return list;
    }

    boolean checkZero(String s){
        if(s.length()==1){
            return true;
        }
        return !(s.charAt(0) == '0' && s.charAt(s.length()-1) == '0');
    }

    public static void main(String[] args) {
        String S;
        S = "(0010)";
        System.out.println(Arrays.toString(new AmbiguousCoordinates().ambiguousCoordinates(S).toArray()));

        S = "(123)";
        System.out.println(Arrays.toString(new AmbiguousCoordinates().ambiguousCoordinates(S).toArray()));

        S = "(00011)";
        System.out.println(Arrays.toString(new AmbiguousCoordinates().ambiguousCoordinates(S).toArray()));

        S = "(0123)";
        System.out.println(Arrays.toString(new AmbiguousCoordinates().ambiguousCoordinates(S).toArray()));

        S = "(100)";
        System.out.println(Arrays.toString(new AmbiguousCoordinates().ambiguousCoordinates(S).toArray()));
    }
}
