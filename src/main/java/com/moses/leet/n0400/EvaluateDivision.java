package com.moses.leet.n0400;

import java.util.*;

public class EvaluateDivision {
    // a/b = 3, a/c=2, b/d=1;  c/d
    Map<String, String> strMap = new HashMap<>();
    Map<String, Double> valMap = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size(); i++){
            List<String> l = equations.get(i);
            init(l.get(0));
            init(l.get(1));
            String a = findStringRoot(l.get(0));
            String b = findStringRoot(l.get(1));
            valMap.put(a, values[i] * findValRoot(l.get(1))/findValRoot(l.get(0)));
            strMap.put(a, b);       // a/aRoot,  b/bRoot     aRoot/bRoot = val * bVal/aVal
        }

        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> l = queries.get(i);
            String a = findStringRoot(l.get(0));
            String b = findStringRoot(l.get(1));
            if(!strMap.containsKey(l.get(0)) || !strMap.containsKey(l.get(1)) || !a.equals(b)){
                res[i] = -1d;
                continue;
            }
            if(l.get(0).equals(l.get(1))){
                res[i] = 1d;
                continue;
            }
            res[i] = findValRoot(l.get(0)) / findValRoot(l.get(1));
        }
        return res;
    }

    String findStringRoot(String a){
        if(!strMap.containsKey(a)){
            return null;
        }
        while(!a.equals(strMap.get(a))){
            a = strMap.get(a);
        }
        return a;
    }

    private void init(String a) {
        if(!strMap.containsKey(a)){
            strMap.put(a, a);
            valMap.put(a, 1d);
        }
    }

    double findValRoot(String a){
        double res = 1d;
        while(!a.equals(strMap.get(a))){
            res *= valMap.get(a);
            a = strMap.get(a);
        }
        return res;
    }




    public static void main(String[] args) {
        List<List<String>> equations;
        double[] values;
        List<List<String>> queries;

        equations = Arrays.asList(Arrays.asList("x1","x2"), Arrays.asList("x2","x3"), Arrays.asList("x1","x4"), Arrays.asList("x2","x5"));
        values = new double[]{3.0,0.5,3.4,5.6};
        queries = Arrays.asList(
                Arrays.asList("x3","x4"), Arrays.asList("x4","x3"), Arrays.asList("x6","x6"), Arrays.asList("x0","x0"));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
//Arrays.asList("x2","x4"), Arrays.asList("x1","x5"), Arrays.asList("x1","x3"), Arrays.asList("x5","x5"), Arrays.asList("x5","x1"),

        equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        values = new double[]{2.0, 3.0};
        queries = Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
    }


    public double[] calcEquationFirst(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> strMap = new HashMap<>();
        Map<String, List<Double>> rstMap = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            List<String> l = equations.get(i);
            String a = l.get(0);
            String b = l.get(1);
            if(strMap.containsKey(a)){
                strMap.get(a).add(b);
                rstMap.get(a).add(values[i]);
            } else {
                List<String> li = new ArrayList<>();
                li.add(b);
                strMap.put(a, li);
                List<Double> rsLi = new ArrayList<>();
                rsLi.add(values[i]);
                rstMap.put(a, rsLi);
            }
            if(strMap.containsKey(b)){
                strMap.get(b).add(a);
                rstMap.get(b).add(1/values[i]);
            } else {
                List<String> li = new ArrayList<>();
                li.add(a);
                strMap.put(b, li);
                List<Double> rsLi = new ArrayList<>();
                rsLi.add(1/values[i]);
                rstMap.put(b, rsLi);
            }
        }

        Set<String> visited = new HashSet<>();
        double[] rsts = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            if(!strMap.containsKey(a) && !strMap.containsKey(b)){
                rsts[i] = -1d;
                continue;
            }
            if(a.equals(b)){
                rsts[i] = 1.0;
                continue;
            }
            double rst = dfs(a, b, strMap, rstMap,visited);
            rsts[i] = rst;
        }
        return rsts;
    }

    private double dfs(String a, String b, Map<String, List<String>> strMap, Map<String, List<Double>> rstMap, Set<String> visited) {
        if(!strMap.containsKey(a)){
            return -1;
        }
        List<String> list = strMap.get(a);
        for(int i=0; i<list.size(); i++){
            String next = list.get(i);
            if(b.equals(next)){
                return rstMap.get(a).get(i);
            }
            if(visited.contains(next)){
                continue;
            }
            visited.add(a);
            double nRst = dfs(next, b, strMap, rstMap, visited);
            visited.remove(a);
            if(nRst != -1){
                return rstMap.get(a).get(i) * nRst;
            }
        }
        return -1;
    }


}
