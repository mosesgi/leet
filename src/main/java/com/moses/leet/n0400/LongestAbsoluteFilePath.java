package com.moses.leet.n0400;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if(input==null || input.length() == 0){
            return 0;
        }
        int max = 0;
        int prev = 0;
        int level = 0;
        Stack<FileInfo> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '\n' || i==input.length()-1){
                String s = input.substring(prev, i);
                if(i==input.length()-1){
                    s = input.substring(prev);
                }
                //process FileInfo
                FileInfo prevLevel = null;
                if(!stack.isEmpty()){
                    prevLevel = stack.peek();
                    while(prevLevel.level>=level){
                        stack.pop();
                        if(stack.isEmpty()){
                            prevLevel = null;
                            break;
                        } else {
                            prevLevel = stack.peek();
                        }
                    }
                }
                int prevLength = 0;
                if(prevLevel != null){
                    prevLength = prevLevel.length + 1;
                }
                boolean isFile = s.contains(".");
                FileInfo curr = new FileInfo(level, prevLength+s.length(), isFile);
                if(isFile && prevLength + s.length() > max){
                    max = prevLength + s.length();
                }
                stack.push(curr);

                prev = i+1;
                level = 0;
            }else if(c == '\t'){
                level++;
                prev = i+1;
            }
        }
        return max;
    }

    class FileInfo{
        String name;
        int level;
        int length;
        boolean isFile;

        FileInfo(int level, int length, boolean isFile){
            this.level = level;
            this.length = length;
            this.isFile = isFile;
        }
    }

    public static void main(String[] args) {
        String input;

        input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath(input));
    }
}
