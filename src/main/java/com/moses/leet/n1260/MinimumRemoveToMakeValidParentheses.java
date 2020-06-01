package com.moses.leet.n1260;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c != '(' && c!= ')'){
                sb.append(c);
                continue;
            }
            if(c== ')'){
                if(cnt == 0){
                    continue;
                }else{
                    cnt--;
                    sb.append(c);
                }
            }else if(c=='('){
                cnt++;
                sb.append(c);
            }
        }

        if(cnt > 0) {
            StringBuilder right = new StringBuilder();
            int i = sb.length()-1;
            for (; i>=0 && cnt>0; i--){
                if(sb.charAt(i) == '('){
                    cnt--;
                }else{
                    right.insert(0, sb.charAt(i));
                }
            }
            sb.setLength(i+1);
            sb.append(right);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("))(("));
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)d)e)"));
    }
}
