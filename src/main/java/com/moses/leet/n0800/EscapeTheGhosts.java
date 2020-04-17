package com.moses.leet.n0800;

public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);

        for(int[] g : ghosts){
            int d = Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]);
            if(d<=distance){
                return false;
            }
        }
        return true;
    }
}
