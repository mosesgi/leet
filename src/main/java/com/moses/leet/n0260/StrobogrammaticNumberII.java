package com.moses.leet.n0260;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        int[] all = new int[]{0,1,8};
        int[] side = new int[]{6,9};

        List<String> res = new ArrayList<>();
        if(n%2==1){
            for(int i=0; i<all.length; i++) {
                dfs(all[i]+"", n, all, side, res);
            }
        }else{
            dfs("", n, all, side, res);
        }
        return res;
    }

    private void dfs(String sb, int n, int[] all, int[] side, List<String> res) {
        if(sb.length() == n){
            if(sb.length()>1 && sb.charAt(0) == '0'){
                return;
            }
            res.add(sb);
            return;
        }
        dfs(side[0]+sb+side[1], n, all, side, res);
        dfs(side[1]+sb+side[0], n, all, side, res);
        for(int i=0; i<all.length; i++){
            dfs(all[i]+sb+all[i], n, all, side, res);
        }
    }
}
