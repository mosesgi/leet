package com.moses.leet.n0220;

import java.util.*;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();

        Set<String> set = new HashSet<>();
        for(String s : words){
            tree.insert(s);
            set.add(s);
        }

        List<String> rst = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                searchBoard(board, i, rows, j, cols, tree, "", rst, set);
            }
        }
        return rst;
    }

    private void searchBoard(char[][] board, int currRow, int rows, int currCol, int cols, Trie tree, String str, List<String> rst, Set<String> set) {
        if(currRow < 0 || currRow > rows-1 || currCol < 0 || currCol > cols-1){
            if(tree.search(str) && set.contains(str)){
                rst.add(str);
                tree.delete(str);
                set.remove(str);
            }
            return;
        }
        if(board[currRow][currCol] == '.'){
            return;
        }
        if(!tree.exist(str)){
            return;
        }
        if(tree.search(str) && set.contains(str)){
            rst.add(str);
            tree.delete(str);
            set.remove(str);
        }
        char tmp = board[currRow][currCol];
        board[currRow][currCol] = '.';
        searchBoard(board, currRow-1, rows, currCol, cols, tree, str + tmp, rst, set);
        searchBoard(board, currRow+1, rows, currCol, cols, tree, str + tmp, rst, set);
        searchBoard(board, currRow, rows, currCol-1, cols, tree, str + tmp, rst, set);
        searchBoard(board, currRow, rows, currCol+1, cols, tree, str + tmp, rst, set);
        board[currRow][currCol] = tmp;
    }

    class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String s){
            Node curr = root;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                int index = c-'a';
                if(curr.subs[index] == null){
                    curr.subs[index] = new Node();
                }
                curr.subs[index].cnt++;
                curr = curr.subs[index];
                if(i==s.length()-1){
                    curr.val = s;
                    curr.isEnd = true;
                }
            }

        }

        public boolean exist(String s){
            Node curr = root;
            for(char c : s.toCharArray()){
                int index = c-'a';
                if(curr.subs[index] == null){
                    return false;
                }
                curr = curr.subs[index];
            }
            return true;
        }

        public boolean search(String s){
            Node curr = root;
            for(char c : s.toCharArray()){
                int index = c-'a';
                if(curr.subs[index] == null){
                    return false;
                }
                curr = curr.subs[index];
            }
            return curr.isEnd && curr.val.equals(s);
        }

        public void delete(String s){
            Node curr = root;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                int index = c-'a';
                if(curr.subs[index] == null){
                    return;
                }
                curr.subs[index].cnt--;
                if(curr.subs[index].cnt == 0){
                    curr.subs[index] = null;
                    return;
                }
                curr = curr.subs[index];
            }
        }
    }

    class Node{
        String val;
        Node[] subs;
        int cnt;
        boolean isEnd;

        Node(){
            subs = new Node[26];
        }

    }


    public static void main(String[] args) {
        String[] words;
        char[][] board;

        words = new String[]{"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        board = new char[][]{
                {'b','a','a','b','a','b'},
                {'a','b','a','a','a','a'},
                {'a','b','a','a','a','b'},
                {'a','b','a','b','b','a'},
                {'a','a','b','b','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','b','a','a','b'}};
        System.out.println(Arrays.toString(new WordSearchII().findWords(board, words).toArray()));

        words = new String[]{"aaa"};
        board = new char[][]{{'a','a'}};
        System.out.println(Arrays.toString(new WordSearchII().findWords(board, words).toArray()));

        words = new String[]{"a"};
        board = new char[][]{{'a'}};
        System.out.println(Arrays.toString(new WordSearchII().findWords(board, words).toArray()));

        words = new String[]{"oath","pea","eat","rain"};
        board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        System.out.println(Arrays.toString(new WordSearchII().findWords(board, words).toArray()));
    }

}
