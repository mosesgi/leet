package com.moses.leet.n0740;

import com.moses.leet.utils.PrintUtil;

import java.util.*;

public class AccountsMerge {

    //disjoint set
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] ary = new int[accounts.size()];
        for(int i=0; i<ary.length; i++){
            ary[i] = i;
        }
        Map<Integer, TreeSet<String>> idEmailsMap = new HashMap<>();
        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> emailIdMap = new HashMap<>();
        for(int i=0; i<accounts.size(); i++){
            TreeSet<String> set = new TreeSet<>();
            idEmailsMap.put(i, set);
            List<String> l = accounts.get(i);
            nameMap.put(i, l.get(0));
            for(int j=1; j<l.size(); j++){
                if(emailIdMap.containsKey(l.get(j)) && emailIdMap.get(l.get(j)) != i){
                    int dupId = emailIdMap.get(l.get(j));
                    int rootId = findRootId(dupId, ary);
                    ary[rootId] = i;
                }
                emailIdMap.put(l.get(j), i);
                set.add(l.get(j));
            }
        }

        for(int i=0; i<accounts.size(); i++) {
            int rootId = findRootId(i, ary);
            if(rootId == i){
                continue;
            }
            nameMap.remove(i);
            idEmailsMap.get(rootId).addAll(idEmailsMap.get(i));
        }

        List<List<String>> list = new ArrayList<>();
        for(int key:nameMap.keySet()){
            List<String> l = new ArrayList<>();
            l.add(nameMap.get(key));
            l.addAll(idEmailsMap.get(key));
            list.add(l);
        }
        return list;

    }

    int findRootId(int id, int[] ary){
        int tmp = id;
        while(ary[tmp] != tmp){
            tmp = ary[tmp];
        }
        return tmp;
    }


    public List<List<String>> accountsMergeSlow(List<List<String>> accounts) {
        Map<Integer, String> nameMap = new HashMap<>();
        Map<Integer, TreeSet<String>> idToEmailsMap = new HashMap<>();
        Map<String, Integer> emailToIdMap = new HashMap<>();

        for(int i=0; i<accounts.size(); i++){
            List<String> list = accounts.get(i);
            TreeSet<String> set = new TreeSet<>();
            nameMap.put(i, list.get(0));
            idToEmailsMap.put(i, set);
            for(int j=1; j<list.size(); j++){
                set.add(list.get(j));
                if(emailToIdMap.containsKey(list.get(j))){
                    int dupId = emailToIdMap.get(list.get(j));
                    if(dupId == i){
                        continue;
                    }
                    for(String s : idToEmailsMap.get(dupId)) {
                        emailToIdMap.put(s, i);
                        idToEmailsMap.get(i).add(s);
                    }
                    nameMap.remove(dupId);
                }
                emailToIdMap.put(list.get(j), i);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(int key : nameMap.keySet()){
            List<String> l = new ArrayList<>();
            l.add(nameMap.get(key));
            l.addAll(idToEmailsMap.get(key));
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
        accounts.add(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
        accounts.add(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
        accounts.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
        PrintUtil.printNestedList(new AccountsMerge().accountsMerge(accounts));
    }
}
