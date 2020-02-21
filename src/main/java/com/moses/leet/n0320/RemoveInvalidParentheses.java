package com.moses.leet.n0320;

import java.util.*;

public class RemoveInvalidParentheses {

    //remove one, and BFS the result
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()){
            String str = q.poll();
            if(isValid(str)){
                list.add(str);
                found = true;
            }
            if(found){
                continue;
            }
            StringBuilder sb = new StringBuilder(str);
            for(int i=0; i<str.length(); i++){
                char tmp = sb.charAt(i);
                if(tmp != '(' && tmp != ')'){
                    continue;
                }
                sb.deleteCharAt(i);
                String tmpStr = sb.toString();
                if(visited.contains(tmpStr)){
                    sb.insert(i, tmp);
                    continue;
                }
                q.offer(tmpStr);
                visited.add(tmpStr);
                sb.insert(i, tmp);
            }
        }
        return list;
    }




    Set<String> rst = new HashSet<>();
    int max = 0;
    public List<String> removeInvalidParenthesesSlowest(String s) {
        if(isValid(s)){
            return Arrays.asList(s);
        }

        StringBuilder sb = new StringBuilder();
        recursive(sb, s,0);

        return new ArrayList<>(rst);
    }

    private void recursive(StringBuilder sb, String s, int pos) {
        if(pos == s.length()){
            if(sb.length() > max && isValid(sb.toString())){
                max = sb.length();
                rst.clear();
                rst.add(sb.toString());
            } else if(sb.length() == max && isValid(sb.toString())){
                rst.add(sb.toString());
            }
            return;
        }
        sb.append(s.charAt(pos));
        recursive(sb, s, pos+1);
        sb.setLength(sb.length()-1);
        recursive(sb, s, pos+1);
    }

    private boolean isValid(String s){
        if(s.length() == 0){
            return true;
        }
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            } else if(s.charAt(i) == ')'){
                cnt--;
            }
            if(cnt <0){
                return false;
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        String s;
        s = "()())()";
        System.out.println(Arrays.toString(new RemoveInvalidParentheses().removeInvalidParentheses(s).toArray()));

        s = "(a)())()";
        System.out.println(Arrays.toString(new RemoveInvalidParentheses().removeInvalidParentheses(s).toArray()));

        s = ")(";
        System.out.println(Arrays.toString(new RemoveInvalidParentheses().removeInvalidParentheses(s).toArray()));

        s = "((()((s((((()";
        System.out.println(Arrays.toString(new RemoveInvalidParentheses().removeInvalidParentheses(s).toArray()));

    }
}
