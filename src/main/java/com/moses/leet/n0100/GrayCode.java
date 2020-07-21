package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    /**
     * 3
     *
     * 000
     * 001
     * 011
     * 010
     * 110
     * 111
     * 101
     * 100
     */
    public List<Integer> grayCode(int n) {
        if(n==0){
            return Arrays.asList(0);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for(int i=2; i<=n; i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            for(int j=list.size()-1; j>=0; j--){
                tmp.add(list.get(j) | (1<<(i-1)));
            }
            list = tmp;
        }
        return list;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
            return res;
        }
        int size = (int)Math.pow(2, n);
        boolean[] visited = new boolean[size];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("0");
        }
        dfs(sb, visited, res, size);
        return res;
    }

    boolean dfs(StringBuilder sb, boolean[] visited, List<Integer> res, int size){
        if(res.size() == size){
            return true;
        }

        int cur = Integer.valueOf(sb.toString(), 2);
        if(visited[cur]){
            return false;
        }
        res.add(cur);
        visited[cur] = true;

        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i, '1');
            }else{
                sb.setCharAt(i, '0');
            }
            if(dfs(sb, visited, res, size)){
                return true;
            }
            sb.setCharAt(i, c);
        }

        visited[cur] = false;
        res.remove(res.size() - 1);
        return false;
    }





    public List<Integer> grayCodeOld(int n){
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
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(new GrayCode().grayCode(2).toArray()));      //00,01,11,10
        System.out.println(Arrays.toString(new GrayCode().grayCode(0).toArray()));
        System.out.println(Arrays.toString(new GrayCode().grayCode(3).toArray()));      //000,001,011,010,110,111,101,100

        //0000,0001,0011,0010,0110,0111,0101,0100,1100,1101,1111,1110,1010,1011,1001,1000
        System.out.println(Arrays.toString(new GrayCode().grayCode(4).toArray()));
    }
}
