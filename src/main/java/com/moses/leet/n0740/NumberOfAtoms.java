package com.moses.leet.n0740;

import java.util.*;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Stack<Element> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Integer cnt = null;
        for(int i=0; i<formula.length(); i++){
            char c = formula.charAt(i);
            if(c == '('){
                if(sb.length()>0){
                    int count = cnt==null?1:cnt;
                    if(stack.isEmpty()) {
                        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
                    }else{
                        stack.push(new Element(sb.toString(), count));
                    }
                    sb.setLength(0);
                    cnt = null;
                }
                stack.push(new Element(true));
            }else if(c == ')'){
                if(sb.length()>0){
                    int count = cnt==null?1:cnt;
                    stack.push(new Element(sb.toString(), count));
                    sb.setLength(0);
                    cnt = null;
                }
                StringBuilder num = new StringBuilder();
                while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                    num.append(formula.charAt(i+1));
                    i++;
                }
                int number = num.length()==0?1:Integer.parseInt(num.toString());

                List<Element> list = new ArrayList<>();
                while(!stack.peek().isParenthesis){
                    Element el = stack.pop();
                    list.add(el);
                }
                stack.pop();    //left parenthesis
                if(!stack.isEmpty()){
                    for(Element el : list){
                        el.count = el.count*number;
                        stack.push(el);
                    }
                }else{
                    for(Element el : list) {
                        map.put(el.name, map.getOrDefault(el.name, 0) + el.count * number);
                    }
                }
            }else if(Character.isUpperCase(c)){
                if(sb.length()>0){
                    int count = cnt==null?1:cnt;
                    if(stack.isEmpty()) {
                        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
                    }else{
                        stack.push(new Element(sb.toString(), count));
                    }
                    sb.setLength(0);
                    cnt = null;
                }
                sb.append(c);
            }else if(Character.isLowerCase(c)){
                sb.append(c);
            }else if(Character.isDigit(c)){
                if(cnt == null){
                    cnt = Integer.parseInt(c+"");
                }else{
                    cnt= cnt*10 + Integer.parseInt(c+"");
                }
            }
        }
        if(sb.length()>0){
            int count = cnt==null?1:cnt;
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
        }

        StringBuilder rst = new StringBuilder();
        for(String key: map.keySet()){
            rst.append(key);
            int count = map.get(key);
            if(count > 1){
                rst.append(count);
            }
        }
        return rst.toString();

    }

    class Element{
        boolean isParenthesis;
        String name;
        Integer count;

        public Element(String name, Integer count){
            this.name = name;
            this.count = count;
        }

        public Element(boolean isParenthesis){
            this.isParenthesis = isParenthesis;
        }
    }


    public static void main(String[] args) {
        String formula;
        formula = "H11He49NO35B7N46Li20";
        System.out.println(new NumberOfAtoms().countOfAtoms(formula));

        formula = "H2O";
        System.out.println(new NumberOfAtoms().countOfAtoms(formula));

        formula = "Mg(OH)2";
        System.out.println(new NumberOfAtoms().countOfAtoms(formula));

        formula = "K4(ON(SO3)2)2";
        System.out.println(new NumberOfAtoms().countOfAtoms(formula));
    }
}
