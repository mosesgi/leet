package com.moses.leet.n0480;


import java.util.*;

public class SlidingWindowMedian {
    //O(NlgK), Two TreeSets.
    //Sort by value and then index, store index in Set.
    public double[] medianSlidingWindow(int[] nums, int k){
        Comparator<Integer> comp = (o1, o2) ->{return nums[o1]!=nums[o2]?Integer.compare(nums[o1],nums[o2]):o1-o2;};
        TreeSet<Integer> left = new TreeSet<>(comp.reversed());
        TreeSet<Integer> right = new TreeSet<>(comp);
        int len = nums.length;
        double[] rst = new double[len-k+1];
        for(int i=0; i<k; i++){
            left.add(i);
        }
        balance(left, right);
        int idx = 0;
        rst[idx++] = left.size() == right.size()?((long)nums[left.first()]+nums[right.first()])/2d:nums[right.first()];
        for(int i=0; i<len-k; i++){
            if(left.contains(i)){
                left.remove(i);
            }else{
                right.remove(i);
            }
            if(left.size() > 0 && nums[i+k] < nums[left.first()]){
                left.add(i+k);
            }else{
                right.add(i+k);
            }
            balance(left, right);
            rst[idx++] = left.size() == right.size()?((long)nums[left.first()]+nums[right.first()])/2d:nums[right.first()];
        }
        return rst;
    }

    void balance(TreeSet<Integer> left, TreeSet<Integer> right){
        while(left.size()>right.size()){
            right.add(left.pollFirst());
        }
        while(left.size()<right.size()-1){
            left.add(right.pollFirst());
        }
    }

    //O(NK), remove/add costs O(K)
    public double[] medianSlidingWindowMine(int[] nums, int k) {
        List<Integer> kList = new ArrayList<>();
        for(int i=0; i<k; i++){
            kList.add(nums[i]);
        }
        Collections.sort(kList);
        boolean isEven = false;
        int mid = k/2;
        if(k%2 == 0){
            isEven = true;
        }
        double[] rst = new double[nums.length-k+1];
        int idx = 0;
        rst[idx++] = getMedian(kList, isEven, mid);
        for(int i=0; i<nums.length-k; i++){
            int del = Collections.binarySearch(kList, nums[i]);
            kList.remove(del);
            int insert = Collections.binarySearch(kList, nums[i+k]);
            int in = insert<0?-insert-1:insert;
            kList.add(in, nums[i+k]);
            rst[idx++] = getMedian(kList, isEven, mid);
        }
        return rst;
    }

    double getMedian(List<Integer> kList, boolean isEven, int mid){
        if(isEven){
            long a = kList.get(mid-1);
            long b = kList.get(mid);
            return (a+b)/2d;
        }else{
            return kList.get(mid);
        }
    }

    public static void main(String[] args) {
        int[] nums; int k;
        nums = new int[]{6,5,9,5,4,9,1,7,5,5};
        k=4;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));

        nums = new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        k=2;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));

        nums = new int[]{1,1,1,1};
        k=2;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));

        nums = new int[]{1,3,-1,-3,5,3,6,7};
        k=3;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));
    }
}
