package com.moses.leet.n0080;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path){
        char[] chars = path.toCharArray();
        Stack<String> stack = new Stack<>();
        boolean inWord = false;
        int wordStart=0, wordEnd=0;
        for(int i=0; i<chars.length; i++){
            //start of '/'
            if(i==0 && chars[i] == '/' && !inWord){
                inWord = true;
                wordStart = i;
                continue;
            } else if(!inWord && chars[i-1] == '/' && chars[i] != '/'){
                inWord = true;
                wordStart = i-1;
                wordEnd = i;
                if(i==chars.length-1){
                    processStr(path, stack, wordStart, wordEnd);
                }
                continue;
            }
            //skip unnecessary '/'
            if(inWord && chars[i-1] == '/' && chars[i] == '/'){
                wordStart = i;
                continue;
            }
            if(inWord && chars[i] != '/'){
                wordEnd = i;
                if(i==chars.length-1){
                    processStr(path, stack, wordStart, wordEnd);
                }
            } else if(inWord && chars[i] == '/'){
                inWord = false;
                processStr(path, stack, wordStart, wordEnd);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    private void processStr(String path, Stack<String> stack, int wordStart, int wordEnd) {
        String str = path.substring(wordStart + 1, wordEnd + 1);
        if (str.equals(".")) {

        } else if (str.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(str);
        }
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/../";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/a/./b/../../c/";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/a/../../b/../c//.//";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/home//foo/";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/a//b////c/d//././/..";
        System.out.println(new SimplifyPath().simplifyPath(path));

        path = "/abc///ccc//dd///..///";
        System.out.println(new SimplifyPath().simplifyPath(path));

    }
}
