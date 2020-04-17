package com.moses.leet.n0800;

public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] cnt = new int[26];
        for(char c : T.toCharArray()){
            cnt[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(cnt[c-'a'] > 0){
                int size = cnt[c-'a'];
                for(int i=0; i<size; i++){
                    sb.append(c);
                }
                cnt[c-'a'] = 0;
            }
        }
        for(int i=0; i<26; i++){
            if(cnt[i] > 0){
                char c = (char)('a'+i);
                for(int j=0; j<cnt[i]; j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
