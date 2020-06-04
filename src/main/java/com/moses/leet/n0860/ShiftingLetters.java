package com.moses.leet.n0860;

/**
 * We have a string S of lowercase letters, and an integer array shifts.
 *
 * Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 *
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 *
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 *
 * Return the final string after all such shifts to S are applied.
 *
 * Example 1:
 *
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation:
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 *
 * Note:
 *
 *     1 <= S.length = shifts.length <= 20000
 *     0 <= shifts[i] <= 10 ^ 9
 *
 */
public class ShiftingLetters {
    //3,8,17
    public String shiftingLetters(String S, int[] shifts) {
        char[] schar = S.toCharArray();
        long[] cnt = new long[S.length()];
        long total = 0;
        for(int i : shifts){
            total+=i;
        }
        cnt[0] = total%26;
        for(int i=1; i<cnt.length; i++){
            total-=shifts[i-1];
            cnt[i] = total;
            cnt[i] %=26;
        }

        for(int i=0; i<schar.length; i++){
            if(schar[i] + cnt[i] > 'z'){
                schar[i] = (char)(schar[i]+cnt[i] - 'z' -1 + 'a');
            }else{
                schar[i] = (char)(schar[i]+cnt[i]);
            }
        }
        return new String(schar);
    }

    public static void main(String[] args) {
        String S;
        int[] shifts;
        S = "ruu";
        shifts = new int[]{26,9,17};
        System.out.println(new ShiftingLetters().shiftingLetters(S, shifts));

        S = "bad";
        shifts = new int[]{10,20,30};
        System.out.println(new ShiftingLetters().shiftingLetters(S, shifts));
    }
}
