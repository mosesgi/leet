package com.moses.leet.n0380;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public  List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            return list;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for(int i=0; i<nums1.length; i++){
            q.offer(new int[]{nums1[i], nums2[0], 0});      //third number: nums1's current nums2 position
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            list.add(Arrays.asList(curr[0], curr[1]));
            if(list.size() == k){
                break;
            }
            if(curr[2] == nums2.length-1){
                continue;
            }
            q.offer(new int[]{curr[0], nums2[curr[2]+1], curr[2]+1});
        }
        return list;
    }


    // O(KN) N = nums1.length
    public List<List<Integer>> kSmallestPairsMine(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            return rst;
        }
        int[] cache = new int[nums1.length];
        int cnt = 0;
        outer: while(cnt < k ){
            List<Integer> minPoses = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            boolean found = false;
            for(int i=0; i<cache.length; i++){
                if(cache[i] == nums2.length){
                    continue;
                }
                found = true;
                int tmp = nums1[i] + nums2[cache[i]];
                if(tmp < min){
                    min = nums1[i] + nums2[cache[i]];
                    minPoses.clear();
                    minPoses.add(i);
                } else if(tmp == min){
                    minPoses.add(i);
                }
            }
            if(!found){
                break;
            }
            for(Integer i: minPoses){
                rst.add(Arrays.asList(nums1[i], nums2[cache[i]++]));
                cnt++;
                if(cnt == k){
                    break outer;
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums1, nums2;
        int k;

        nums1 = new int[]{-10,-4,0,0,6};
        nums2 = new int[]{3,5,6,7,8,100};
        k = 10;
        for(List<Integer> l : new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k)){
            System.out.print(Arrays.toString(l.toArray()) + ", ");
        }
        System.out.println();

        nums1 = new int[]{1,1,2};
        nums2 = new int[]{1,2,3};
        k = 10;
        for(List<Integer> l : new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k)){
            System.out.print(Arrays.toString(l.toArray()) + ", ");
        }
        System.out.println();

        nums1 = new int[]{1,7,11};
        nums2 = new int[]{2,4,6};
        k = 3;
        for(List<Integer> l : new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k)){
            System.out.print(Arrays.toString(l.toArray()) + ", ");
        }
        System.out.println();

        nums1 = new int[]{1,1,2};
        nums2 = new int[]{1,2,3};
        k = 2;
        for(List<Integer> l : new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k)){
            System.out.print(Arrays.toString(l.toArray()) + ", ");
        }
        System.out.println();

        nums1 = new int[]{1,2};
        nums2 = new int[]{3};
        k=3;
        for(List<Integer> l : new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k)){
            System.out.print(Arrays.toString(l.toArray()) + ", ");
        }
        System.out.println();

    }
}
