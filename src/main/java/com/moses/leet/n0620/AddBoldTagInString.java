package com.moses.leet.n0620;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the
 * substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair
 * of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 *
 * Example 1:
 *
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 *
 *
 *
 * Example 2:
 *
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 *
 *
 *
 * Constraints:
 *
 *     The given dict won't contain duplicates, and its length won't exceed 100.
 *     All the strings in input have length in range [1, 1000].
 *
 * Note: This question is the same as 758: https://leetcode.com/problems/bold-words-in-string/
 *
 */
public class AddBoldTagInString {

    //copy from solution
    public String addBoldTag(String S, String[] words) {
        int N = S.length();
        boolean[] mask = new boolean[N];
        for (int i = 0; i < N; ++i) {
            inner: for (String word : words) {
                for (int k = 0; k < word.length(); ++k) {
                    if (k + i >= S.length() || S.charAt(k + i) != word.charAt(k))
                        continue inner;
                }
                for (int j = i; j < i + word.length(); ++j) {
                    mask[j] = true;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            if (mask[i] && (i == 0 || !mask[i-1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == N-1 || !mask[i+1]))
                ans.append("</b>");
        }
        return ans.toString();
    }

}
