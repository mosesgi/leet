package com.moses.leet.n0780;

import java.util.*;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] m = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(m[i], 1);

        }
        for(int[] mi : mines){
            m[mi[0]][mi[1]] = 0;
        }

        int big = 0;
        outer: for(int i=big; i<N-big; i++){
            for(int j=big; j<N-big; j++){
                int arm = findPlusSignMatrix(N, m, i, j);
                if(arm > big){
                    big = arm;
                    i = arm-1;
                    continue outer;
                }
            }
        }
        return big;

    }

    private int findPlusSignMatrix(int n, int[][] m, int i, int j) {
        if(m[i][j] == 0){
            return 0;
        }
        int arm = 1;
        while(true){
            if(i-arm < 0 || m[i-arm][j] == 0){
                return arm;
            }
            if(i+arm >=n || m[i+arm][j] == 0){
                return arm;
            }
            if(j-arm < 0 || m[i][j-arm] == 0){
                return arm;
            }
            if(j+arm >=n || m[i][j+arm] == 0){
                return arm;
            }
            arm++;
        }
    }

    public int orderOfLargestPlusSignMap(int N, int[][] mines) {
        Map<Integer, Set<Integer>> zeroMap = new HashMap<>();
        for(int[] m : mines){
            zeroMap.putIfAbsent(m[0], new HashSet<>());
            zeroMap.get(m[0]).add(m[1]);
        }

        int big = 0;
        outer: for(int i=big; i<N-big; i++){
            for(int j=big; j<N-big; j++){
                int arm = findPlusSign(N, zeroMap, i, j);
                if(arm > big){
                    big = arm;
                    i = arm-1;
                    continue outer;
                }
            }
        }
        return big;
    }

    private int findPlusSign(int n, Map<Integer, Set<Integer>> zeroMap, int i, int j) {
        int arm = 0;
        if(zeroMap.containsKey(i) && zeroMap.get(i).contains(j)){
            return arm;
        }
        arm++;
        while(true){
            //up
            if(i-arm<0 || zeroMap.containsKey(i-arm) && zeroMap.get(i-arm).contains(j)){
                return arm;
            }
            //down
            if(i+arm>=n || zeroMap.containsKey(i+arm) && zeroMap.get(i+arm).contains(j)){
                return arm;
            }
            //left
            if(j-arm<0 || zeroMap.containsKey(i) && zeroMap.get(i).contains(j-arm)){
                return arm;
            }
            //right
            if(j+arm >=n || zeroMap.containsKey(i) && zeroMap.get(i).contains(j+arm)){
                return arm;
            }
            arm++;
        }
    }

    public static void main(String[] args) {
        int[][] mines;
        int N;
        N=3;
        mines = new int[][]{{0,0}};
        System.out.println(new LargestPlusSign().orderOfLargestPlusSign(N, mines));

        N=5;
        mines = new int[][]{{4,2}};
        System.out.println(new LargestPlusSign().orderOfLargestPlusSign(N, mines));
    }

}
