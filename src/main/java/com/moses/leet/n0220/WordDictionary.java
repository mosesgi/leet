package com.moses.leet.n0220;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.subs[index] == null){
                curr.subs[index]=new Node(ch);
            }
            curr = curr.subs[index];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return recursive(root, word, 0);
    }

    private boolean recursive(Node node, String word, int curPos){
        if(node == null){
            return false;
        }
        char ch = word.charAt(curPos);
        int index = ch-'a';
        if(curPos == word.length()-1){
            if(ch != '.'){
                if(node.subs[index] == null){
                    return false;
                }
                return node.subs[index].isEnd;
            } else {
                for(int i=0; i<node.subs.length; i++){
                    if(node.subs[i] != null && node.subs[i].isEnd){
                        return true;
                    }
                }
                return false;
            }
        }

        if(ch == '.'){
            for(int i=0; i<node.subs.length; i++){
                if(recursive(node.subs[i], word, curPos+1)){
                    return true;
                }
            }
        } else {
            return recursive(node.subs[index], word, curPos + 1);
        }
        return false;
    }

    class Node{
        Node[] subs;
        Character val;
        boolean isEnd;

        Node(){
            subs = new Node[26];
        }

        Node(Character val){
            subs = new Node[26];
            this.val = val;
        }
    }

    public static void main(String[] args) {
        WordDictionary wd;

        wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));       //false
        System.out.println(wd.search(".at"));       //true
        wd.addWord("bat");       //true
        System.out.println(wd.search(".at"));       //true
        System.out.println(wd.search("an."));       //true
        System.out.println(wd.search("a.d."));       //true
        System.out.println(wd.search("b."));       //true
        System.out.println(wd.search("a.d"));       //true
        System.out.println(wd.search("."));       //true

        wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));       //false
        System.out.println(wd.search("bad"));       //true
        System.out.println(wd.search(".ad"));       //true
        System.out.println(wd.search("b.."));       //true
    }
}
