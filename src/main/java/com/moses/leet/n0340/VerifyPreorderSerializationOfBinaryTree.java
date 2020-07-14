package com.moses.leet.n0340;

import java.util.Stack;

public class VerifyPreorderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] items = preorder.split(",");
        for(String item : items){
            while("#".equals(item) && !stack.isEmpty() && "#".equals(stack.peek())){
                stack.pop();
                if(stack.isEmpty() || "#".equals(stack.peek())){
                    return false;
                }
                stack.pop();
            }
            stack.push(item);
        }
        return stack.size()==1 && "#".equals(stack.peek());
    }

    //Regex is even slower than origin version.
    public boolean isValidSerializationRegex(String preorder) {
        if("#".equals(preorder)){
            return true;
        }
        if(preorder.length() < 5){
            return false;
        }
        while(true){
            String n = preorder.replaceAll("[0-9]+,#,#", "#");
            if(n.length() == preorder.length()){
                break;
            }
            preorder = n;
        }
        return "#".equals(preorder);
    }


    public boolean isValidSerializationFirst(String preorder) {
        if("#".equals(preorder)){
            return true;
        }
        if(!preorder.endsWith("#,#")){
            return false;
        }

        String[] ary = preorder.split(",");
        if(ary.length < 3){
            return false;
        }else if(ary.length == 3){
            if(!"#".equals(ary[0]) && "#".equals(ary[1]) && "#".equals(ary[2])){
                return true;
            }else {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ary.length; i++){
            if(!"#".equals(ary[i]) && "#".equals(ary[i+1]) && "#".equals(ary[i+2])){
                sb.append("#");
                i+=2;
            } else {
                sb.append(ary[i]);
            }
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        return isValidSerialization(sb.toString());
    }

    public static void main(String[] args) {
        String s;
        s = "9,3,4,#,#,10,#,#,2,#,6,#,#";
//        s = s.replaceAll("[0-9]+,#,#", "#");
//        System.out.println(s);
//        System.out.println(s.matches("[0-9]+,#,#"));
//        s = s.replaceAll("[0-9]+,#,#", "#");
//        System.out.println(s);
//        System.out.println(s.matches("[0-9]+,#,#"));

        System.out.println(new VerifyPreorderSerializationOfBinaryTree().isValidSerialization(s));

        s = "1,#";
        System.out.println(new VerifyPreorderSerializationOfBinaryTree().isValidSerialization(s));

        s = "9,#,#,1";
        System.out.println(new VerifyPreorderSerializationOfBinaryTree().isValidSerialization(s));

    }
}
