package com.moses.leet.n0220;

public class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new Node();
            }
            cur = cur.children[ch-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char ch : prefix.toCharArray()){
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }

    class Node{
        Node[] children;
        boolean isWord;

        public Node(){
            children = new Node[26];
        }
    }







//    static final int AB_NUM = 26;
//    static final char BASE = 'a';
//    Node root;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new Node();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        char[] wc = word.toCharArray();
//        Node node = root;
//        for(int i=0; i<wc.length; i++){
//            char curr = wc[i];
//            int index = curr-BASE;
//            if(node.alphabets[index] == null){
//                node.alphabets[index] = new Node(curr);
//            }
//            if(i == wc.length-1){
//                node.alphabets[index].endFlag = true;
//            }
//            node = node.alphabets[index];
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        char[] wc = word.toCharArray();
//        Node node = root;
//        for(int i=0; i<wc.length; i++){
//            char curr = wc[i];
//            int index = curr-BASE;
//            if(node.alphabets[index] == null){
//                return false;
//            }
//            if(i == wc.length-1){
//                return node.alphabets[index].endFlag;
//            }
//            node = node.alphabets[index];
//        }
//        return false;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        char[] pc = prefix.toCharArray();
//        Node node = root;
//        for(int i=0; i<pc.length; i++){
//            int index = pc[i]-BASE;
//            if(node.alphabets[index] == null){
//                return false;
//            }
//            node = node.alphabets[index];
//        }
//        return true;
//    }
//
//
//    class Node{
//        Character val;
//        Node[] alphabets;
//        boolean endFlag;
//
//        public Node(Character val){
//            this.val = val;
//            alphabets = new Node[AB_NUM];
//        }
//
//        public Node(){
//            alphabets = new Node[AB_NUM];
//        }
//    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
