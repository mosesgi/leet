package com.moses.leet.lcci;

public class OneAwayLCCI {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length() -second.length()) >1){
            return false;
        }
        if(first.equals(second)){
            return true;
        }
        return firstDiff(first, second, 0, 0);
    }

    private boolean firstDiff(String first, String second, int pos1, int pos2) {
        while(pos1<first.length() && pos2<second.length()){
            if(first.charAt(pos1) != second.charAt(pos2)){
                return secondDiff(first, second, pos1+1, pos2+1) || secondDiff(first, second, pos1+1, pos2)
                        || secondDiff(first, second, pos1, pos2+1);
            }
            pos1++;
            pos2++;
        }
        return true;
    }

    private boolean secondDiff(String first, String second, int pos1, int pos2){
        while(pos1 < first.length() && pos2 < second.length()){
            if(first.charAt(pos1) != second.charAt(pos2)){
                return false;
            }
            pos1++;
            pos2++;
        }
        if(pos1<first.length() || pos2<second.length()){
            return false;
        }
        return true;
    }
}
