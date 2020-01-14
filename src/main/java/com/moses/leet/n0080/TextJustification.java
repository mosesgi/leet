package com.moses.leet.n0080;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rst = new ArrayList<>();
        List<String> eachLine = new ArrayList<>();
        int currLen = 0;
        for(int i=0; i<words.length-1; i++){
            currLen += words[i].length();
            eachLine.add(words[i]);
            if(currLen + words[i+1].length() + 1 <= maxWidth){
                currLen++;      //add space
            } else {
                String lineWord = adjustSpaces(eachLine, currLen, maxWidth);
                rst.add(lineWord);
                eachLine = new ArrayList<>();
                currLen = 0;
            }
        }
        eachLine.add(words[words.length-1]);
        StringBuilder lastLine = new StringBuilder();
        for(int i=0; i<eachLine.size(); i++){
            lastLine.append(eachLine.get(i));
            if(i!=eachLine.size()-1){
                lastLine.append(" ");
            }
        }
        int leftSpaces = maxWidth - lastLine.length();
        for(int i=0; i<leftSpaces; i++){
            lastLine.append(" ");
        }
        rst.add(lastLine.toString());
        return rst;
    }

    private String adjustSpaces(List<String> eachLine, int wordsLength, int maxWidth) {
        wordsLength = wordsLength - (eachLine.size()-1);
        int spaces = maxWidth - wordsLength;
        int wordsNum = eachLine.size();
        if(wordsNum == 1){
            StringBuilder sb = new StringBuilder(eachLine.get(0));
            for(int i=0; i<spaces; i++){
                sb.append(" ");
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            int slots = wordsNum - 1;
            int eachSlotSpaces = spaces/slots;
            int mods = spaces%slots;
            for(int i=0; i<eachLine.size(); i++){
                sb.append(eachLine.get(i));
                if(i!=eachLine.size()-1){
                    for(int j=0; j<eachSlotSpaces; j++){
                        sb.append(" ");
                    }
                    if(mods > 0){
                        sb.append(" ");
                        mods--;
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        for(String s: new TextJustification().fullJustify(words, maxWidth)){
            System.out.println(s);
        }
        System.out.println();

        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        for(String s: new TextJustification().fullJustify(words, maxWidth)){
            System.out.println(s);
        }
        System.out.println();

        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        for(String s: new TextJustification().fullJustify(words, maxWidth)){
            System.out.println(s);
        }
        System.out.println();

    }
}
