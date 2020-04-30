package com.moses.leet.n0140;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        gas[0]-=cost[0];
        int sum=gas[0];
        for(int i=1; i<gas.length; i++){
            gas[i] -= cost[i];
            sum+=gas[i];
        }
        if(sum < 0){
            return -1;
        }

        int min = gas[0];
        int minPos = 0;
        for(int i=1; i<gas.length; i++){        //sum together, and find minimum value, return next one.
            gas[i] += gas[i-1];
            if(gas[i] < min){
                min = gas[i];
                minPos = i;
            }
        }
        return (minPos+1)%gas.length;
    }


    public int canCompleteCircuitOld(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++){
            if(gas[i] < cost[i]){
                continue;
            }
            if(canTravelBack(i, gas, cost)){
                return i;
            }
        }
        return -1;
    }

    private boolean canTravelBack(int i, int[] gas, int[] cost){
        int j = i;
        int left = gas[j] - cost[j];
        j++;
        if(j == gas.length){
            j = 0;
        }
        while(j!=i){
            left = left + gas[j] - cost[j];
            if(left < 0){
                return false;
            }
            j++;
            if(j == gas.length){
                j = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas;
        int[] cost;
//        gas = new int[]{2,3,4};
//        cost = new int[]{3,4,3};
//        System.out.println(new GasStation().canCompleteCircuit(gas, cost));

        gas = new int[]{1,2,3,4,5};
        cost = new int[]{3,4,5,1,2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
