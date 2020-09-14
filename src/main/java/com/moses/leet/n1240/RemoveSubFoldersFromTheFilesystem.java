package com.moses.leet.n1240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        for(int i=0; i<folder.length; i++){
            String base = folder[i]+"/";
            res.add(folder[i]);
            while(i+1<folder.length && folder[i+1].startsWith(base)){
                i++;
            }
        }
        return res;
    }
}
