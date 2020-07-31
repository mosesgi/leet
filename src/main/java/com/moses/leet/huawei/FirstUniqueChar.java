package com.moses.leet.huawei;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.nowcoder.com/practice/e896d0f82f1246a3aa7b232ce38029d4?tpId=37&&tqId=21282&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
public class FirstUniqueChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            LinkedHashSet<Character> uniqueSet = new LinkedHashSet<>();
            Set<Character> dupSet = new HashSet<>();
            for(char c : str.toCharArray()){
                if(dupSet.contains(c)){
                    continue;
                }
                if(uniqueSet.contains(c)){
                    uniqueSet.remove(c);
                    dupSet.add(c);
                }else{
                    uniqueSet.add(c);
                }
            }
            if(uniqueSet.isEmpty()){
                System.out.println(-1);
            }else {
                System.out.println(uniqueSet.iterator().next());
            }
        }
    }
}
