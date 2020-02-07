package com.moses.leet.n0160;

import java.util.*;

public class MaxPointsOnALine {
    enum Type{
        ROW,
        COL,
        ITA
    }

    public int maxPoints(int[][] points) {
        if(points.length<3){
            return points.length;
        }
        int max = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        Stack<int[]> stack = new Stack<>();

        int len = points.length;
        for(int i=0; i<len; i++){
            stack.push(points[i]);
            int tmpI = i+1;
            while(tmpI < len && points[tmpI][0] == points[i][0] && points[tmpI][1] == points[i][1]){
                stack.push(points[tmpI]);
                tmpI++;
            }
            i= tmpI-1;
            if(stack.size()>max){
                max = stack.size();
            }
            if(i+1 >=len){
                continue;
            }
            int firstLevel = stack.size();
            for(int j=i+1; j<len; j++){
                stack.push(points[j]);
                int tmpJ = j+1;
                while(tmpJ < len && points[tmpJ][0] == points[j][0] && points[tmpJ][1] == points[j][1]){
                    stack.push(points[tmpJ]);
                    tmpJ++;
                }
                j = tmpJ-1;
                if(stack.size()>max){
                    max = stack.size();
                }
                if(j+1 >=len){
                    continue;
                }
                Type t = Type.ITA;
                double rate = 0;
                if(points[j][0] == points[i][0]){
                    t = Type.COL;
                } else if(points[j][1] == points[i][1]){
                    t = Type.ROW;
                }
                if(t == Type.ITA){
                    rate = (double)(points[j][0]-points[i][0]) / (double)(points[j][1] - points[i][1]);
                }
                for(int k = j+1; k<len; k++){
                    if(t == Type.COL && points[k][0] == points[i][0]){
                        stack.push(points[k]);
                    } else if(t == Type.ROW && points[k][1] == points[i][1]){
                        stack.push(points[k]);
                    } else if((double)(points[k][0]-points[i][0]) / (double)(points[k][1] - points[i][1]) == rate){
                        stack.push(points[k]);
                    }
                }
                if(stack.size() > max){
                    max = stack.size();
                }

                while(stack.size() > firstLevel){
                    stack.pop();
                }
            }
            stack.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{2,2},{3,3}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));       //3

        points = new int[][]{{-240,-657},{-27,-188},{-616,-247},{-264,-311},{-352,-393},{-270,-748},{3,4},{-308,-87},{150,526},{0,-13},{-7,-40},{-3,-10},{-531,-892},{-88,-147},{4,-3},{-873,-555},{-582,-360},{-539,-207},{-118,-206},{970,680},{-231,-47},{352,263},{510,143},{295,480},{-590,-990},{-236,-402},{308,233},{-60,-111},{462,313},{-270,-748},{-352,-393},{-35,-148},{-7,-40},{440,345},{388,290},{270,890},{10,-7},{60,253},{-531,-892},{388,290},{-388,-230},{340,85},{0,-13},{770,473},{0,73},{873,615},{-42,-175},{-6,-8},{49,176},{308,222},{170,27},{-485,-295},{170,27},{510,143},{-18,-156},{-63,-316},{-28,-121},{396,304},{472,774},{-14,-67},{-5,7},{-485,-295},{118,186},{-154,-7},{-7,-40},{-97,-35},{4,-9},{-18,-156},{0,-31},{-9,-124},{-300,-839},{-308,-352},{-425,-176},{-194,-100},{873,615},{413,676},{-90,-202},{220,140},{77,113},{-236,-402},{-9,-124},{63,230},{-255,-118},{472,774},{-56,-229},{90,228},{3,-8},{81,196},{970,680},{485,355},{-354,-598},{-385,-127},{-2,7},{531,872},{-680,-263},{-21,-94},{-118,-206},{616,393},{291,225},{-240,-657},{-5,-4},{1,-2},{485,355},{231,193},{-88,-147},{-291,-165},{-176,-229},{154,153},{-970,-620},{-77,33},{-60,-111},{30,162},{-18,-156},{425,114},{-177,-304},{-21,-94},{-10,9},{-352,-393},{154,153},{-220,-270},{44,-24},{-291,-165},{0,-31},{240,799},{-5,-9},{-70,-283},{-176,-229},{3,8},{-679,-425},{-385,-127},{396,304},{-308,-352},{-595,-234},{42,149},{-220,-270},{385,273},{-308,-87},{-54,-284},{680,201},{-154,-7},{-440,-475},{-531,-892},{-42,-175},{770,473},{118,186},{-385,-127},{154,153},{56,203},{-616,-247}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));

        points = new int[][]{{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));       //6

        points = new int[][]{{3,1},{12,3},{3,1},{-6,-1}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));       //4

        points = new int[][]{{0,0},{1,1},{0,0}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));       //3

        points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));       //4
    }

}
