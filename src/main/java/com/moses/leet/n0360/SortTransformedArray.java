package com.moses.leet.n0360;

import java.util.Arrays;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
 *
 * The returned array must be in sorted order.
 *
 * Expected time complexity: O(n)
 *
 * Example 1:
 *
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 *
 * Example 2:
 *
 * Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * Output: [-23,-5,1,7]
 *
 */
public class SortTransformedArray {

    //copy from discussion
    private int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    /**
     * 首先了解抛物线概念,https://baike.baidu.com/item/%E6%8A%9B%E7%89%A9%E7%BA%BF%E6%96%B9%E7%A8%8B/2021428
     * 极点概念:的https://baike.baidu.com/item/%E6%9E%81%E5%80%BC%E7%82%B9
     * 首先根据 a = 0, bx + c是一条直线 学名斜截式概念: https://baike.baidu.com/item/%E6%96%9C%E6%88%AA%E5%BC%8F
     * b是斜率, 斜率大于零则x值越大y也越大, 斜率小于0则x越大,y值越小.
     * 如果是抛物线则必然存在一个极点(极大值/极小值), 极点就是导数为0的点, f(x)导数: 2ax+b = 0 ==> x = -b/2a
     * a > 0, 则抛物线是一条向上的抛物线,存在极小值, x坐标点到极点的绝对值越小则f(x) 越小,反则反之.
     * a < 0, 则抛物线是一条向下的抛物线,存在极大值, x坐标点到极点的绝对值越小则f(x) 越大,反则反之.
     * @param nums
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] temp = new int[nums.length];
        if (a == 0) {
            if (b == 0)
                Arrays.fill(temp, c);

            for (int i = 0; i < nums.length; i++) {
                if (b > 0)
                    temp[i] = b * nums[i] + c;
                else
                    temp[nums.length - 1 - i] = b * nums[i] + c;
            }
            return temp;
        }
        int index = 0;
        double mid = -b * 1.0 / a / 2;
        int l = 0, r = nums.length - 1;
        if (a > 0) {
            index = nums.length - 1;
            while (l <= r) {
                if (Math.abs(mid - nums[l]) > Math.abs(mid - nums[r]))
                    // 最大值
                    temp[index] = cal(nums[l++], a, b, c);
                else
                    temp[index] = cal(nums[r--], a, b, c);
                index--;
            }

        } else {
            while (l <= r) {
                if (Math.abs(mid - nums[l]) > Math.abs(mid - nums[r]))
                    // 最小值
                    temp[index++] = cal(nums[l++], a, b, c);
                else
                    temp[index++] = cal(nums[r--], a, b, c);
            }
        }
        return temp;
    }

}
