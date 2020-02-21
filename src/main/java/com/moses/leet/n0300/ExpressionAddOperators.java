package com.moses.leet.n0300;

import java.util.*;

public class ExpressionAddOperators {

    //elegant implementation by others:
    //https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
    //https://leetcode.com/problems/expression-add-operators/discuss/71897/Java-AC-solution-19ms-beat-100.00.

    List<String> rst = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        List<List<String>> numbers = generateNumbers(num);

        List<List<String>> moreNumbs = new ArrayList<>();
        for(List<String> l : numbers){
            if(l.size() == 1 ){
                try {
                    if(Integer.parseInt(l.get(0)) == target) {
                        rst.add(l.get(0));
                    }
                } catch(Exception e){
                }
            } else {
                moreNumbs.add(l);
            }
        }

        List<List<String>> exps = generateExps(moreNumbs);

//        for(List<String> l : exps){
//            StringBuilder sb = new StringBuilder();
//            for(String s : l){
//                sb.append(s);
//            }
//            System.out.println(sb.toString());
//        }

        for(List<String> exp : exps){
            try {
                int res = calculate(exp);
                if (res == target) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : exp) {
                        sb.append(s);
                    }
//                System.out.println(sb.toString());
                    rst.add(sb.toString());
                }
            } catch(Exception e){
            }
        }
        return rst;
    }

    private int calculate(List<String> exp) throws Exception {
        Deque<String> q = new LinkedList<>();
        for(int i=0; i<exp.size(); i++){
            String s = exp.get(i);
            if("*".equals(s)){
                int left = Integer.parseInt(q.pollLast());
                i++;
                int right = Integer.parseInt(exp.get(i));
                q.offerLast(String.valueOf(left*right));
                continue;
            }
            q.offerLast(s);
        }
        if(q.size() == 1){
            return Integer.parseInt(q.pollFirst());
        }

        while(q.size()!=1){
            String l = q.pollFirst();
            String op = q.pollFirst();
            String r = q.pollFirst();
            if("+".equals(op)){
                q.offerFirst(String.valueOf(Integer.parseInt(l) + Integer.parseInt(r)));
            } else if("-".equals(op)){
                q.offerFirst(String.valueOf(Integer.parseInt(l) - Integer.parseInt(r)));
            }
        }
        return Integer.parseInt(q.pollFirst());
    }

    private List<List<String>> generateExps(List<List<String>> numbers) {
        List<List<String>> rst = new ArrayList<>();
        for(List<String> l : numbers){
            List<List<String>> one = generateOneExp(l);
            rst.addAll(one);
        }
        return rst;
    }

    private List<List<String>> generateOneExp(List<String> numbs){
        List<List<String>> curr = new ArrayList<>();
        if(numbs.size()==2){
            curr.add(Arrays.asList(numbs.get(0), "+", numbs.get(1)));
            curr.add(Arrays.asList(numbs.get(0), "-", numbs.get(1)));
            curr.add(Arrays.asList(numbs.get(0), "*", numbs.get(1)));
            return curr;
        }
        String currStr = numbs.get(0);
        List<List<String>> next = generateOneExp(numbs.subList(1, numbs.size()));
        for(List<String> l : next){
            List<String> tmp = new ArrayList<>();
            tmp.add(currStr); tmp.add("+");
            tmp.addAll(l);
            curr.add(tmp);
            tmp = new ArrayList<>();
            tmp.add(currStr); tmp.add("-");
            tmp.addAll(l);
            curr.add(tmp);
            tmp = new ArrayList<>();
            tmp.add(currStr); tmp.add("*");
            tmp.addAll(l);
            curr.add(tmp);
        }
        return curr;
    }

    private List<List<String>> generateNumbers(String num) {
        if(num.length() == 0){
            return new ArrayList<>();
        }
        if(num.startsWith("0")){
            List<List<String>> list = generateNumbers(num.substring(1));
            if(list.isEmpty()){
                List<String> l = new ArrayList<>();
                l.add("0");
                list.add(l);
            }else {
                for (List<String> l : list) {
                    l.add(0, "0");
                }
            }
            return list;
        }
        List<List<String>> curr = new ArrayList<>();
        for(int i=1; i<=num.length(); i++){
            String left = num.substring(0, i);
            List<List<String>> list = generateNumbers(num.substring(i));
            if(list.isEmpty()){
                List<String> l = new ArrayList<>();
                l.add(left);
                curr.add(l);
            }else {
                for (List<String> l : list) {
                    l.add(0, left);
                    curr.add(l);
                }
            }
        }
        return curr;
    }

    public static void main(String[] args) {
//        new ExpressionAddOperators().addOperators("12345", 45);

        List<String> rst;

        rst = new ExpressionAddOperators().addOperators("000", 0);
        Collections.sort(rst);
        for(String s : rst){
            System.out.println(s);
        }

//        rst = new ExpressionAddOperators().addOperators("123456789", 45);
//        Collections.sort(rst);
//        for(String s : rst){
//            System.out.println(s);
//        }

//        rst = new ExpressionAddOperators().addOperators("3456237490", 9191);
//        Collections.sort(rst);
//        for(String s : rst){
//            System.out.println(s);
//        }
//
//        rst = new ExpressionAddOperators().addOperators("105", 5);
//        Collections.sort(rst);
//        for(String s : rst){
//            System.out.println(s);
//        }
//        new ExpressionAddOperators().addOperators("123", 6);
//        new ExpressionAddOperators().addOperators("232", 8);
//        new ExpressionAddOperators().addOperators("105", 5);
//        new ExpressionAddOperators().addOperators("00", 0);
//        new ExpressionAddOperators().addOperators("3456237490", 9191);
    }

}