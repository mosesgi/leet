package com.moses.leet.n0660;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        boolean[] banned = new boolean[senate.length()];
        while(true){
            for(int i=0; i<senate.length(); i++){
                if(banned[i]){
                    continue;
                }
                char c = senate.charAt(i);
                if(banOther(c, senate, banned, i)){
                    return c == 'R'? "Radiant":"Dire";
                }
            }
        }
    }

    private boolean banOther(char c, String senate, boolean[] banned, int start) {
        char toBan = c=='R'? 'D':'R';
        boolean atLeastOne = false;
        for(int i=start+1, j=0; j<senate.length(); i++, j++){
            if(i == senate.length()){
                i = 0;
            }
            if(banned[i] || senate.charAt(i)!=toBan){
                continue;
            }
            atLeastOne = true;
            banned[i] = true;
            break;
        }
        return !atLeastOne;
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("RDD"));
        System.out.println(new Dota2Senate().predictPartyVictory("RD"));
    }
}
