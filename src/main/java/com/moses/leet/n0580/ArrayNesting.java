package com.moses.leet.n0580;


public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max = 0;
        boolean[] traveled = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(traveled[i]){
                continue;
            }
            int j = nums[i];
            int cnt = 1;
            traveled[i] = true;
            while(!traveled[j]){
                traveled[j] = true;
                j = nums[j];
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,1,2};
        System.out.println(new ArrayNesting().arrayNesting(nums));

        nums = new int[]{5,4,0,3,1,6,2};
        System.out.println(new ArrayNesting().arrayNesting(nums));
    }
}
