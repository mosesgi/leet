package com.moses.leet.huawei;

import java.util.*;

/**
 * 题目描述
 *
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * 详细描述：
 * 接口说明
 * 原型：
 * voidencrypt(char * key,char * data,char * encrypt);
 *
 * 输入参数：
 * char * key：密匙
 * char * data：明文
 * 输出参数：
 * char * encrypt：密文
 * 返回值：
 * void
 *
 * 输入描述:
 * 先输入key和要加密的字符串
 * 输出描述:
 * 返回加密后的字符串
 *
 * 示例1
 * 输入
 * 复制
 *
 * nihao
 * ni
 *
 * 输出
 * 复制
 *
 * le
 */
public class EncryptByWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String key = scan.next();
            String source = scan.next();

            key = key.toLowerCase();
            TreeSet<Character> secretUnUsed = new TreeSet<>();
            for(char c = 'a'; c <='z'; c++){
                secretUnUsed.add(c);
            }
            int p = 0;
            Map<Character, Character> map = new HashMap<>();
            for(char cur = 'a'; cur <='z'; ){
                if(p < key.length()) {
                    char fromKey = key.charAt(p);
                    if (secretUnUsed.contains(fromKey)) {
                        map.put(cur, fromKey);
                        secretUnUsed.remove(fromKey);
                        p++;
                        cur++;
                    }else{
                        p++;
                    }
                }else{
                    map.put(cur, secretUnUsed.pollFirst());
                    cur++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c : source.toCharArray()){
                boolean isUpper = Character.isUpperCase(c);
                char s = Character.toLowerCase(c);
                if(map.containsKey(s)) {
                    char secret = map.get(s);
                    secret = isUpper ? Character.toUpperCase(secret) : secret;
                    sb.append(secret);
                }else{
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}
