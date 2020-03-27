package com.moses.leet.n0620;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        if(flowerbed.length==1 && flowerbed[0] == 0){
            n--;
            return n==0;
        }
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            if(i==0 && i+1<flowerbed.length && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n==0){
                    return true;
                }
                continue;
            }
            if(i==flowerbed.length-1 && i-1 >=0 && flowerbed[i-1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n==0){
                    return true;
                }
                continue;
            }
            if(i-1 >=0 && i+1 < flowerbed.length && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n==0){
                    return true;
                }
            }
        }
        return false;
    }
}
