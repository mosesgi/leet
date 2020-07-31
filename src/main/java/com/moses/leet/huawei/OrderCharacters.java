package com.moses.leet.huawei;

import java.util.Scanner;

//https://www.nowcoder.com/practice/2de4127fda5e46858aa85d254af43941?tpId=37&&tqId=21257&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
public class OrderCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int[] cnt = new int[128];
            for(char c : str.toCharArray()){
                cnt[c-' ']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<cnt.length; i++){
                if(cnt[i] > 0){
                    char c = (char) (i + ' ');
                    for(int j=0; j<cnt[i];j++) {
                        sb.append(c);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
