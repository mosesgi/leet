package com.moses.leet.n0140;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * https://leetcode.com/problems/word-ladder-ii/discuss/40447/Share-two-similar-Java-solution-that-Accpted-by-OJ.
 */
public class WordLadderII {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> rstList = new ArrayList<>();
        rstList.add(beginWord);
        recursive(beginWord, endWord, wordList, rstList);
        int min = Integer.MAX_VALUE;

        List<List<String>> finalList = new ArrayList<>();
        for(List<String> l : result){
            if(l.size()<min){
                finalList.clear();
                min = l.size();
                finalList.add(l);
            } else if(l.size() == min){
                finalList.add(l);
            }
        }
        return finalList;
    }

    //time limit exceeded
    private void recursive(String beginWord, String endWord, List<String> wordList, List<String> rstList){
        if(wordList.size() == 0){
            return;
        }
        if(beginWord.equals(endWord)){
            result.add(new ArrayList<>(rstList));
            return;
        }
        for(String str : wordList){
            List<String> tmpList = new ArrayList<>(wordList);
            tmpList.remove(str);
            if(isAdjacent(beginWord, str)){
                rstList.add(str);
                recursive(str, endWord, tmpList, rstList);
                rstList.remove(rstList.size()-1);
            }
        }
    }

    private List<String> findNextList(String curr, List<String> wordList){
        List<String> list = new ArrayList<>();
        for(String s : wordList){
            if(isAdjacent(curr, s)){
                list.add(s);
            }
        }
        return list;
    }

    private boolean isAdjacent(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }


    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        List<List<String>> rst = new WordLadderII().findLadders(beginWord, endWord, wordList);
        PrintUtil.printNestedList(rst);
    }

}
