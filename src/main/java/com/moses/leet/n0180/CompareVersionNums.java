package com.moses.leet.n0180;

public class CompareVersionNums {

    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int size = v1s.length<v2s.length?v2s.length:v1s.length;
        for(int i=0; i<size; i++){
            int v1=0,v2=0;
            if(i<v1s.length){
                v1 = Integer.parseInt(v1s[i]);
            }
            if(i<v2s.length){
                v2 = Integer.parseInt(v2s[i]);

            }
            if(v1 != v2){
                return v1>v2?1:-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNums().compareVersion("0.1", "1.1"));
        System.out.println(new CompareVersionNums().compareVersion("1.0.1", "1"));
        System.out.println(new CompareVersionNums().compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(new CompareVersionNums().compareVersion("1.01", "1.001"));
        System.out.println(new CompareVersionNums().compareVersion("1.0", "1.0.0"));
    }
}
