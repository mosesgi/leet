package com.moses.leet.n0740;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {
    public int evaluate(String expression) {
        return eval(expression, 1, new ArrayList<>())[0];
    }

    private int[] eval(String str, int start, List<Map<String, Integer>> context) {
        String exp = str.substring(start, start+3);
        String exp1 = str.substring(start, start+4);
        if("let".equals(exp)){
            Map<String, Integer> ct = new HashMap<>();
            context.add(ct);
            StringBuilder sb = new StringBuilder();
            String key = null;
            Integer val = null;
            for(int i=start+4; i<str.length(); i++){
                if(str.charAt(i) == ' '){
                    if(key == null){
                        key = sb.toString();
                        sb.setLength(0);
                    }else{
                        val = resolveParam(sb.toString(), context);
                        ct.put(key, val);
                        key = null;
                        val = null;
                        sb.setLength(0);
                    }
                }else if(str.charAt(i) == '(') {
                    int[] next = eval(str, i+1, context);
                    val = next[0];
                    if(key != null){
                        ct.put(key, val);
                        key = null;
                        val = null;
                        i = next[1];
                    }else if(key == null){
                        i = next[1] -1;
                    }
                }else if(str.charAt(i) == ')'){
                    int value = sb.length()>0?resolveParam(sb.toString(), context):val;
                    int[] ret = new int[]{value, i+1};
                    context.remove(context.size()-1);
                    return ret;
                }else{
                    sb.append(str.charAt(i));
                }
            }
        } else {        // if("add".equals(exp) || "mult".equals(exp1))
            if("add".equals(exp)){
                start = start+4;
            }else{
                start = start+5;
            }
            StringBuilder sb = new StringBuilder();
            Integer x = null, y = null;
            boolean isDigit = false;
            for(int i=start; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == ' '){
                    if(x==null){
                        x = isDigit?Integer.parseInt(sb.toString()):resolveParam(sb.toString(), context);
                    }else{
                        y = isDigit?Integer.parseInt(sb.toString()):resolveParam(sb.toString(), context);
                    }
                    sb.setLength(0);
                }else if(c == '('){
                    int[] next = eval(str, i+1, context);
                    if(x==null){
                        x = next[0];
                        i = next[1];
                    }else{
                        y = next[0];
                        i = next[1]-1;
                    }
                }else if(c == ')'){
                    if(y==null){
                        y = isDigit?Integer.parseInt(sb.toString()):resolveParam(sb.toString(), context);
                    }
                    return new int[]{"add".equals(exp)?x+y:x*y, i+1};
                }else {
                    if (sb.length() == 0) {
                        isDigit = Character.isDigit(c);
                    }
                    sb.append(c);
                }
            }
        }
        return new int[]{-1, -1};
    }

    int resolveParam(String param, List<Map<String, Integer>> map){
        try{
            return Integer.parseInt(param);
        }catch(Exception e){
            for(int i=map.size()-1; i>=0; i--){
                Map<String, Integer> m = map.get(i);
                if(m.containsKey(param)){
                    return m.get(param);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String exp;

        exp = "(let x -2 y x y)";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 7 -12)";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(add 1 2)";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(mult 3 (add 2 3))";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 2 (mult x 5))";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 3 x 2 x)";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 1 y 2 x (add x y) (add x y))";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let x 2 (add (let x 3 (let x 4 x)) x))";
        System.out.println(new ParseLispExpression().evaluate(exp));

        exp = "(let a1 3 b2 (add a1 1) b2) ";
        System.out.println(new ParseLispExpression().evaluate(exp));
    }
}
