package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    public class Codec {
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
