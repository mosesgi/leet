package com.moses.leet.n0180;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums){
        Integer[] nubs = new Integer[nums.length];
        for(int i=0; i<nubs.length; i++){
            nubs[i] = nums[i];
        }
        Arrays.sort(nubs, (o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            }
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);

            String s1big = s1 + s2;
            String s2big = s2 + s1;
            for(int i=0; i<s1big.length(); i++){
                if(s1big.charAt(i) < s2big.charAt(i)){
                    return -1;
                } else if(s1big.charAt(i) > s2big.charAt(i)){
                    return 1;
                }
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=nubs.length-1; i>=0; i--){
            if(i==nubs.length-1 && nubs[i] == 0){
                return "0";
            }
            sb.append(nubs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398};
        System.out.println(new LargestNumber().largestNumber(nums).equals("98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048"));

        nums = new int[]{12,121};
        System.out.println(new LargestNumber().largestNumber(nums));

        nums = new int[]{10,2};
        System.out.println(new LargestNumber().largestNumber(nums));

        nums = new int[]{3,30,34,5,9};
        System.out.println(new LargestNumber().largestNumber(nums));

                       //89,8,86,867,863,828,822,8227,8223,8221,588,566,56,5,53,528
        nums = new int[]{5,56,53,566,588,528,8,86,89,828,822,863,867,8221,8223,8227};
        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
