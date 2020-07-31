package com.moses.leet.huawei;

import java.util.Scanner;

//https://www.nowcoder.com/practice/e8480ed7501640709354db1cc4ffd42a?tpId=37&&tqId=21286&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
public class DNAGcRatio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int len = scan.nextInt();
            if(len > str.length()){
                System.out.println("");
                continue;
            }
            int[] cnt = new int[str.length()+1];
            for(int i=1; i<=str.length(); i++){
                char c = str.charAt(i-1);
                if(c=='G' || c=='C'){
                    cnt[i] = cnt[i-1] + 1;
                }else{
                    cnt[i] = cnt[i-1];
                }
            }
            int max = 0;
            int l = -1, r = -1;
            for(int i=len; i<=str.length(); i++){
                int tmp = cnt[i] - cnt[i-len];
                if(tmp > max){
                    max = tmp;
                    l = i-len;
                    r = i;
                }
            }
            System.out.println(str.substring(l, r));
        }
    }
}
