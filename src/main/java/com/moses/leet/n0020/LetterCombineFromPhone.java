package com.moses.leet.n0020;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombineFromPhone {
    public List<String> letterCombinations(String digits) {
        String[] keys = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        backtrack(digits, keys, 0, "", list);
        return list;
    }

    private void backtrack(String digits, String[] keys, int pos, String tmpString, List<String> list){
        if(pos == digits.length()){
            if(tmpString.length() != 0) {
                list.add(tmpString);
            }
            return;
        }
        char curr = digits.charAt(pos);
        int num = curr-'0';
        for(int i=0; i<keys[num].length(); i++){
            backtrack(digits, keys, pos+1, tmpString + keys[num].charAt(i), list);
        }
    }

    Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> result = new ArrayList<>();


    public List<String> letterCombinationsOld(String digits){
        if(digits.length() != 0) {
            recursiveCombine("", digits);
        }
        return result;
    }

    public void recursiveCombine(String combine, String remainingDigits){
        if(remainingDigits.length() == 0){      //no more digits to handle, one recursion complete.
            result.add(combine);
            return;
        }
        char currDigit = remainingDigits.charAt(0);
        String mapping = map.get(currDigit);
        for(int i=0; i<mapping.length(); i++){
            recursiveCombine(combine + mapping.charAt(i), remainingDigits.substring(1));
        }
    }


    public static void main(String[] args) {
        String input = "23";
        List<String> list = new LetterCombineFromPhone().letterCombinations(input);
        System.out.println(Arrays.toString(list.toArray(new String[]{})));
    }
}
