package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    public class Codec {
        Map<String, String> longToShortMap = new HashMap<>();
        Map<String, String> shortToLongMap = new HashMap<>();
        static final String BASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        static final String baseUrl = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if(longToShortMap.containsKey(longUrl)){
                return longToShortMap.get(longUrl);
            }

            String tmp = "";
            do {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                //generate 8 chars random string
                for(int i=0; i<8; i++){
                    sb.append(BASE.charAt(random.nextInt(62)));
                }
                tmp = sb.toString();
            } while (shortToLongMap.containsKey(tmp));
            shortToLongMap.put(tmp, longUrl);
            longToShortMap.put(longUrl, tmp);
            return baseUrl + tmp;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortToLongMap.get(shortUrl.replace(baseUrl, ""));
        }
    }


    public class Codec1 {
        Map<Integer, String> db = new HashMap<>();
        int key = 0;
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            db.put(key, longUrl);
            int tmp = key;
            key++;
            return tmp+"";
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int idx = Integer.parseInt(shortUrl);
            return db.get(idx);
        }
    }


}
