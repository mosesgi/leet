package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n){
        List<Integer> list = new ArrayList<>();
        if(n==0){
            list.add(0);
            return list;
        }
        List<String> strs = new ArrayList<>();
        generateInts(strs, n);
        for(String s : strs){
            list.add(Integer.valueOf(s, 2));
        }
        return list;
    }

    private void generateInts(List<String> list, int n) {
        if(n==1){
            list.add("0");
            list.add("1");
            return;
        }
        generateInts(list, n-1);
        List<String> tmpList = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--){
            String tmpStr = list.get(i);
            if(n-1 > tmpStr.length()){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n-1-tmpStr.length(); j++){
                    sb.append("0");
                }
                sb.append(tmpStr);
                tmpStr = sb.toString();
            }
            tmpList.add("1" + tmpStr);
        }
        list.addAll(tmpList);
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new GrayCode().grayCode(2).toArray()));      //00,01,11,10
        System.out.println(Arrays.toString(new GrayCode().grayCode(0).toArray()));
        System.out.println(Arrays.toString(new GrayCode().grayCode(3).toArray()));      //000,001,011,010,110,111,101,100

        //0000,0001,0011,0010,0110,0111,0101,0100,1100,1101,1111,1110,1010,1011,1001,1000
        System.out.println(Arrays.toString(new GrayCode().grayCode(4).toArray()));
    }
}
