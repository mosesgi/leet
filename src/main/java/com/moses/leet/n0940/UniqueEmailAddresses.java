package com.moses.leet.n0940;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s:emails){
            String[] splits = s.split("@");
            String domain = splits[1];
            String head = splits[0];
            StringBuilder sb = new StringBuilder();
            for(char c : head.toCharArray()){
                if(c=='.'){
                    continue;
                }else if(c=='+'){
                    break;
                }else{
                    sb.append(c);
                }
            }
            set.add(sb.toString() +"@"+domain);
        }
        return set.size();
    }
}
