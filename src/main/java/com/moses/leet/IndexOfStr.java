
package com.moses.leet;

public class IndexOfStr {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();

        int j= 0;
        int start = -1;
        boolean firstMatched = false;
        for(int i=0; i<=hay.length-need.length; i++){
            if(hay[i] == need[j]){
                if(!firstMatched){
                    firstMatched = true;
                    start = i;
                    j++;
                    if(j>=need.length){
                        return start;
                    }
                    for(int k = i+1; k<need.length+i; k++){
                        if(hay[k] != need[j++]){
                            firstMatched = false;
                            start = -1;
                            j=0;
                            break;
                        }
                        if(j>=need.length){
                            return start;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(new IndexOfStr().strStr(haystack, needle));

        haystack = "mississippi"; needle = "issipi";
        System.out.println(new IndexOfStr().strStr(haystack, needle));
        
        haystack = "mississippi"; needle = "mississippi";
        System.out.println(new IndexOfStr().strStr(haystack, needle));


        haystack = "mississippi"; needle = "issip";
        System.out.println(new IndexOfStr().strStr(haystack, needle));

        haystack = "aaa"; needle = "a";
        System.out.println(new IndexOfStr().strStr(haystack, needle));

        haystack = "aaaaa"; needle = "bba";
        System.out.println(new IndexOfStr().strStr(haystack, needle));

        haystack = "a"; needle="a";
        System.out.println(new IndexOfStr().strStr(haystack, needle));

    }
}