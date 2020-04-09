package com.moses.leet.n0740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveComments {
    //  /*fdafa*/dfafa/*fwowoeiw*/feowgjoijbq/*aaa
    //  fasjfaoifa*/ fasdfa /*
    boolean inCommentBlock = false;
    public List<String> removeComments(String[] source) {
        List<String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String s : source){
            String cur = oneLine(s, 0);
            if(inCommentBlock){
                sb.append(cur);
            }else{
                sb.append(cur);
                if(sb.length()>0){
                    rst.add(sb.toString());
                }
                sb.setLength(0);
            }
        }
        return rst;
    }

    String oneLine(String s, int start){
        if(inCommentBlock){
            int pos = s.indexOf("*/", start);
            if(pos>=0){
                inCommentBlock = false;
                return oneLine(s, pos+2);
            }else{
                return "";
            }
        }else{
            int comment = s.indexOf("//", start);
            int pos = s.indexOf("/*", start);
            if(comment >=0 && pos>=0){
                if(comment<pos){
                    return s.substring(start, comment);
                }else{
                    inCommentBlock = true;
                    return s.substring(start, pos) + oneLine(s, pos+2);
                }
            }else if(comment < 0) {
                if (pos >= 0) {
                    inCommentBlock = true;
                    return s.substring(start, pos) + oneLine(s, pos + 2);
                } else {
                    return s.substring(start);
                }
            }else{
                return s.substring(start, comment);
            }
        }
    }


    public static void main(String[] args) {
        String[] source;
        source = new String[]{"a//*b//*c","blank","d*//e*//f"};
        System.out.println(Arrays.toString(new RemoveComments().removeComments(source).toArray()));

        source = new String[]{"/*fdafa/*/zzzz*/dfafa/*fwowoeiw*/feowgjoijbq/*aaa", "fasjfaoifa*/ int main() /**//*aaabb", "cc*/{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(Arrays.toString(new RemoveComments().removeComments(source).toArray()));

        source = new String[]{"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        System.out.println(Arrays.toString(new RemoveComments().removeComments(source).toArray()));

        source = new String[]{"a/*comment", "line", "more_comment*/b"};
        System.out.println(Arrays.toString(new RemoveComments().removeComments(source).toArray()));

        source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(Arrays.toString(new RemoveComments().removeComments(source).toArray()));

    }
}
