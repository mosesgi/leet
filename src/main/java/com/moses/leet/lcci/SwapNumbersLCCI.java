package com.moses.leet.lcci;

//https://leetcode-cn.com/problems/swap-numbers-lcci/
public class SwapNumbersLCCI {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
