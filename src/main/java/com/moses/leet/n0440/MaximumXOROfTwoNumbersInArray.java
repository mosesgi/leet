package com.moses.leet.n0440;

public class MaximumXOROfTwoNumbersInArray {

    class TrieNode{
        int val;
        TrieNode[] nodes;
        TrieNode(){
            nodes = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums){
        TrieNode root = new TrieNode();

        for(int i: nums){
            TrieNode node = root;
            for(int j=31; j>=0; j--){
                int curr = (i>>>j) & 1;
                if(node.nodes[curr] == null){
                    node.nodes[curr] = new TrieNode();
                }
                node = node.nodes[curr];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i: nums){
            TrieNode node = root;
            int currSum = 0;
            for(int j=31; j>=0; j--){
                int curr = (i>>>j) & 1;
                if(node.nodes[curr^1] != null){
                    currSum += 1 << j;
                    node = node.nodes[curr^1];
                }else{
                    node = node.nodes[curr];
                }
            }
            if(currSum > max){
                max = currSum;
            }
        }
        return max;
    }

    //trivial, O(N2)
    public int findMaximumXOROn2(int[] nums) {
        int max = Integer.MIN_VALUE;
        String rst = null;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int tmp = nums[i] ^ nums[j];
                if(tmp > max){
                    max = tmp;
                    rst = nums[i] + "^" + nums[j] +"=" + tmp;
                }
            }
        }
        System.out.println(rst);
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        //00011
        //01010
        //00101
        //11001
        //00010
        //01000
        nums = new int[]{3,10,5,25,2,8};
        System.out.println(new MaximumXOROfTwoNumbersInArray().findMaximumXOR(nums));

        nums = new int[]{26,27,28,29,30};
        System.out.println(new MaximumXOROfTwoNumbersInArray().findMaximumXOR(nums));

    }
}
