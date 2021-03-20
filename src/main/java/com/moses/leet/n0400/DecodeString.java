package com.moses.leet.n0400;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> strs = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        strs.push(new StringBuilder());

        int num = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            } else if (c == '[') {
                nums.push(num);
                num = 0;
                strs.push(new StringBuilder());
            } else if ( c== ']') {
                StringBuilder prev = strs.pop();
                String single = prev.toString();
                int count = nums.pop() - 1;
                for(int j=0; j<count; j++){
                    prev.append(single);
                }
                strs.peek().append(prev.toString());
            } else {
                strs.peek().append(c);
            }
        }
        return strs.pop().toString();
    }


    public String decodeString1(String s) {
        Stack<String> strStack = new Stack<>();
        strStack.push("");
        Stack<Integer> numStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                int j= i+1;
                while(Character.isDigit(s.charAt(j))){
                    num*=10;
                    num+=s.charAt(j) - '0';
                    j++;
                }
                i=j-1;
                numStack.push(num);
            }else if(c == '['){
                strStack.push("");
            }else if(c == ']'){
                String str = strStack.pop();
                int num = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k<num; k++){
                    sb.append(str);
                }
                strStack.push(strStack.pop()+sb.toString());
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                if(i+1 < s.length()) {
                    int j = i + 1;
                    char cj = s.charAt(j);
                    while (!Character.isDigit(cj) && cj != '[' && cj != ']') {
                        sb.append(cj);
                        j++;
                        if(j == s.length()){
                            break;
                        }
                        cj = s.charAt(j);
                    }
                    i = j-1;
                }
                strStack.push(strStack.pop() + sb.toString());
            }
        }
        return strStack.pop();
    }



    public static void main(String[] args) {
        String s;
        s = "3[a2[bc3[de]fg]h]jkl4[d2[jk]]";
        System.out.println(new DecodeString().decodeString(s));

        s = "3[2[bc]]";
        System.out.println(new DecodeString().decodeString(s));

        s = "3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));

        s = "abcd3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));

        s = "3[a2[c]]";
        System.out.println(new DecodeString().decodeString(s));

        s = "2[abc]3[cd]ef";
        System.out.println(new DecodeString().decodeString(s));
    }
}
