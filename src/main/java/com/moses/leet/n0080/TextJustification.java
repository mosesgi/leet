package com.moses.leet.n0080;

import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        return null;
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
