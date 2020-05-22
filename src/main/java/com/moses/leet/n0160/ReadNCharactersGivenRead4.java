package com.moses.leet.n0160;

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int pos = 0;
        while(pos < n){
            char[] buf4 = new char[4];
            int cnt = read4(buf4);
            for(int i=0; i<cnt && pos < n; i++){
                buf[pos++] = buf4[i];
            }
            if(cnt < 4){
                break;
            }
        }
        return pos;
    }

    int read4(char[] buf){
        return 4;
    }
}
