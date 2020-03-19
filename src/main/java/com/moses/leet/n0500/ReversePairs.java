package com.moses.leet.n0500;

import java.util.*;

public class ReversePairs {


    //Binary search
    public int reversePairs(int[] nums) {
        int sum = 0;
        List<Long> bst = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            bst.add(nums[i] * 2L);
        }
        Collections.sort(bst);
        for(int i=0; i<nums.length-1; i++){
            int delPos = Collections.binarySearch(bst, nums[i] * 2L);
            bst.remove(delPos);

            int pos = Collections.binarySearch(bst, (long)nums[i]);
            if(pos > 0) {
                while (pos - 1 >= 0 && bst.get(pos).equals(bst.get(pos - 1))) {
                    pos--;
                }
            }else if(pos < 0) {
                pos = -pos-1;
            }
            sum+=pos;

        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{6,6,6,5,4,4,4,4,4,3,3,3,3,2,2,2,1,1,1,1,5,4,2,3,3,2,2};
        System.out.println(new ReversePairs().reversePairs(nums));
        System.out.println(new ReversePairs().reversePairsTLE(nums));


        nums = new int[]{-375,156,158,-76,27,-263,50,174,305,22,150,-94,-368,-142,61,119,154,-247,-52,-38,-81,-105,402,-21,-148,2,-28,-164,-387,358,216,168,148,200,4,-222,183,281,-428,-13,2,-289,-459,-188,117,193,140,463,-56,159,29,-250,216,143,12,151,48,174,-105,-83,247,324,-204,-181,71,-184,411,-52,-110,-220,168,46,383,-223,-56,24,322,50,-14,-206,-84,-2,-173,219,150,-356,331,-78,-123,468,-184,243,-160,-96,235,-70,214,253,113,313,-80,201,383,125,83,-124,33,223,-48,-55,-175,-364,-98,52,223,45,90,-23,18,141,71,258,-214,-142,-230,159,-319,-440,219,-217,-72,198,56,240,210,76,22,46,-264,159,-153,-189,-212,317,-420,-71,19,-46,64,-37,-15,-397,-27,-236,-135,268,-223,112,392,-300,371,-209,51,109,-465,-219,-155,-138,77,96,-10,33,77,-366,491,22,83,180,-70,-404,-312,-384,251,8,305,-316,157,-318,435,100,274,123,-180,499,-285,221,-135,-199,145,234,12,-13,-164,133,115,-160,315,149,-36,-164,107,-74,300,-34,246,219,-148,-182,26,-143,-321};
        System.out.println(new ReversePairs().reversePairs(nums));
        System.out.println(new ReversePairs().reversePairsTLE(nums));

        nums = new int[]{2,4,3,5,1};
        System.out.println(new ReversePairs().reversePairs(nums));
    }

    public int reversePairsTLE(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j= i+1; j<nums.length; j++){
                if(nums[i] > (nums[j]<<1)){
                    cnt++;
                }
            }
        }
        return cnt;
    }



}
