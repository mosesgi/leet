package com.moses.leet.n0820;

public class SoupServings {
    public double soupServings(int N) {
        Double[][] mem = new Double[N+1][N+1];
        return dfs(N, N, mem);
    }

    double dfs(int a, int b, Double[][] mem){
        if(a<=0 && b<=0){
            return 0.5;
        }else if(a<=0){
            return 1.0;
        }else if(b<=0){
            return 0d;
        }
        if(mem[a][b] != null){
            return mem[a][b]*0.25;
        }
        double sum = 0d;
        sum += dfs(a-100, b, mem);
        sum += dfs(a-75, b-25, mem);
        sum += dfs(a-50, b-50, mem);
        sum += dfs(a-25, b-75, mem);
        mem[a][b] = sum;
        return sum * 0.25;
    }

    public static void main(String[] args) {
        System.out.println(new SoupServings().soupServings(50));
        System.out.println(new SoupServings().soupServings(850));
        System.out.println(new SoupServings().soupServings(6000));
    }
}
