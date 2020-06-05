package com.moses.leet.n1260;

/**
 * You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].
 *
 * Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "xx", s2 = "yy"
 * Output: 1
 * Explanation:
 * Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
 *
 * Example 2:
 *
 * Input: s1 = "xy", s2 = "yx"
 * Output: 2
 * Explanation:
 * Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
 * Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
 * Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
 *
 * Example 3:
 *
 * Input: s1 = "xx", s2 = "xy"
 * Output: -1
 *
 * Example 4:
 *
 * Input: s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *     1 <= s1.length, s2.length <= 1000
 *     s1, s2 only contain 'x' or 'y'.
 *
 */
public class MinimumSwapsToMakeStringsEqual {
    //xxyyxyxyxx
    //xyyxyxxxyx

    //xyyyxyxyxx
    //xyxxyxxxyx       1-2

    //xyyxxyxyxx
    //xyyxyxxxyx       3-2

    //xyyxyyxyxx
    //xyyxyxxxxx       4-8

    //xyyxyxxyxx
    //xyyxyxxyxx       5-7

    //xxxxyy    yyyyxx
    //xyxxyy    xyyyxx      1-0
    //xyxyyy    xyxyxx      3-2
    //xyxyxy    xyxyxy

    //xxyyx    yxxxy
    //xxyyy    xxxxy
    //xxyxy    xxyxy

    //自己还是差一点...
    public int minimumSwap(String s1, String s2) {
        // 偶数个x,y.
        //1. 完全一致, 过
        //2. 两组上下两个字符排列相同( xx/yy | yy/xx) 则只需1步
        //3. 两组上下两个字符排列不同( xy/yx | yx/xy) 则需2步

        //上下各一个字符为一对, 如果M对xy, N对yx, 且M+N为偶数后:
        //如果M为偶数,则N也为偶数,全部 2类交换 (M+N)/2
        //若M为奇数,N也为奇数,则各拿一组做3类交换, (M-1)/2 + (N-1)/2 + 2 = (M+N)/2 + 1

        int xy=0, yx=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            if(s1.charAt(i) == 'x'){
                xy++;
            }else{
                yx++;
            }
        }
        if( (xy+yx) %2 == 1){
            return -1;
        }
        if( xy%2==0){
            return (xy+yx)/2;
        }else{
            return (xy+yx)/2+1;
        }
    }
}
