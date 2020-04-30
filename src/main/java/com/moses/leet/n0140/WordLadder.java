package com.moses.leet.n0140;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> remain = new HashSet<>();
        remain.addAll(wordList);
        if(!remain.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return steps;
                }
                for(int j=0; j<cur.length(); j++){
                    char[] curChars = cur.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++){
                        curChars[j] = ch;
                        String next = new String(curChars);
                        if(remain.contains(next)){
                            remain.remove(next);
                            q.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }



    public int ladderLengthOld(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty() || !wordList.contains(endWord)){
            return 0;
        }
        Map<String, Integer> steps = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        steps.put(beginWord, 1);
        outer: while(!q.isEmpty()) {
            String curr = q.poll();
            List<String> list = findNextWords(curr, wordList, steps);
            int step = steps.get(curr) + 1;
            for (String s : list) {
                steps.put(s, step);
                if (s.equals(endWord)) {
                    break outer;
                }
                q.offer(s);
            }
        }

        if(steps.containsKey(endWord)){
            return steps.get(endWord);
        } else {
            return 0;
        }

    }

    private List<String> findNextWords(String s, List<String> wordList, Map<String, Integer> steps){
        List<String> list = new ArrayList<>();
        for(String str : wordList){
            if(!steps.containsKey(str)){
                if(adjacent(s, str)){
                    list.add(str);
                }
            }
        }
        return list;
    }

    private boolean adjacent(String a, String b) {
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }


    //from begin to end, incorrect result, cache might be caching big value and stops updating smaller value.
//    private Integer recursiveWrong(String beginWord, String endWord, List<String> wordList) {
//        if(wordList.size() == 0){
//            return null;
//        }
//        if(beginWord.equals(endWord)){
//            return 1;
//        }
//        if(cache.containsKey(beginWord)){
//            return cache.get(beginWord) == null? null: cache.get(beginWord) +1;
//        }
//        Integer shortest = null;
//        for(int i=0; i<wordList.size(); i++){
//            String curr = wordList.get(i);
//            if(adjacent(beginWord, curr)){
//                List<String> l = new ArrayList<>(wordList);
//                l.remove(curr);
//                Integer tmp = recursiveWrong(curr, endWord, l);
//
//                if(tmp != null && (shortest == null || tmp<shortest)){
//                    shortest = tmp;
//                }
//            }
//        }
//        cache.put(beginWord, shortest);
//        return shortest==null?null:shortest+1;
//    }




    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));        //5

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));        //0

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));        //0

        beginWord = "qa";
        endWord = "sq";
        wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));        //5

        beginWord = "cet";
        endWord = "ism";
        wordList = Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));        //11
    }
}
