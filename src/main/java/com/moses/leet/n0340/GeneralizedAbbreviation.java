package com.moses.leet.n0340;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Note: The order of the output does not matter.
 *
 * Example:
 *
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 */
















public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res =new ArrayList<>();
        dfs(word, 0, "", res, false);
        return res;
    }

    private void dfs(String word, int start, String s, List<String> res, boolean isPrevNumber) {
        if(start == word.length()){
            res.add(s);
            return;
        }
        if(start > word.length()){
            return;
        }

        if(isPrevNumber){
            dfs(word, start+1, s+word.charAt(start), res, false);
        }else{
            dfs(word, start+1, s+word.charAt(start), res, false);
            for(int i=1; i<=word.length()-start; i++){
                dfs(word, start+i, s+i, res, true);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GeneralizedAbbreviation().generateAbbreviations("word").toArray()));
    }
}
