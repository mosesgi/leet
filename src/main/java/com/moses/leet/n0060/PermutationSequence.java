package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {

    public String getPermutation(int n, int k){
        List<Integer> array = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            array.add(i+1);
        }
        String str = "";
        //divide it to currPos + (n-1)!
        return recursiveGen(array, n, k, str);
    }

    private int getFactorial(int n){
        int rst = 1;
        for(int i=2; i<=n; i++){
            rst*=i;
        }
        return rst;
    }

    private String recursiveGen(List<Integer> array, int n, int k, String str){
        if(array.size() == 1){
            return str + array.get(0);
        }
        int n_1Factorial = getFactorial(n-1);
        int currPos = (k-1)/n_1Factorial;
        int leftK = k - currPos * n_1Factorial;
        str+=array.get(currPos);
        array.remove(currPos);
        return recursiveGen(array, n-1, leftK, str);
    }

    public static void main(String[] args) {
//        List<String> list = new PermutationSequence().getPermutationObsolete(4, 9);
//        for(String s: list){
//            System.out.println(s);
//        }

        System.out.println(new PermutationSequence().getPermutation(3, 3));
        System.out.println(new PermutationSequence().getPermutation(4, 9));
        System.out.println(new PermutationSequence().getPermutation(1, 1));
        long start = System.currentTimeMillis();
        System.out.println(new PermutationSequence().getPermutation(9, 136371));
        System.out.println(System.currentTimeMillis()- start + "ms");
    }



    List<String> list = new ArrayList<>();
    // Time limit exceeded
    public List<String> getPermutationObsolete(int n, int k){
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = i+1;
        }
        recursive(array, "");
//        return list.get(k-1);
        return list;
    }

    private void recursive(int[] array, String str) {
        if(array.length==0){
            list.add(str);
            return;
        }
        for(int i=0; i<array.length; i++){
            int currN = array[i];

            int[] tmpAry = new int[array.length-1];
            int k = 0;
            for(int j=0; j<array.length; j++){
                if(array[j] != currN) {
                    tmpAry[k++] = array[j];
                }
            }
            recursive(tmpAry, str+currN);
        }
    }
}
