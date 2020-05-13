package com.moses.leet.n0300;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n-1;
        while(l<r){
            int m = l+(r-l)/2;
            int cnt = 0;
            for(int i=0; i<n; i++){
                if(nums[i] <= m){
                    cnt++;
                }
            }
            if(cnt <= m){
                l = m+1;
            }else {
                r = m;
            }
        }
        return r;
    }


    public int findDuplicateCycle(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        //step 1, fast and slow, meet somewhere.
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //step 2, from meet point, one step each, meet at loop starting point... This is fucking insane...
        //https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,3,4,2,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));

        nums = new int[]{3,1,3,4,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
    }

    public int findDuplicateOn2(int[] nums){
        int n = nums.length-1;

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j< nums.length; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }
            if(cnt > 1){
                return nums[i];
            }
        }
        return 0;
    }


}
