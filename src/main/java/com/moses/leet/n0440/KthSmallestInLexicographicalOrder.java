package com.moses.leet.n0440;

//https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/369094/Java-100-Solution-()
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while(k>1){
            long gap = findGap(cur,cur+1, n);
            if(gap < k){
                k-=gap;
                cur++;
            }else{
                cur = cur*10;
                k-=1;
            }
        }
        return (int)cur;
    }

    private long findGap(long curr, long next, int n){
        long gap = 0;
        while(curr <= n){
            gap += Math.min(next, n+1) - curr;
            curr*=10;
            next*=10;
        }
        return gap;
    }

    //1,10,100,1000,1001,..,1009,101,1010,1011,..,1019,102,1020,1021...1029,103,1030,...1099,11,110,1100,
    //TLE
    public int findKthNumberTLE(int n, int k) {
        int[] ref = new int[1];
        ref[0] = k;
        return generateLexi(1, n, 9, ref).intValue();
    }

    private Long generateLexi(long start, int n, int max, int[] ref) {
        for(int i=0; i<max; i++){
            long cur = start+i;
            if(cur > n){
                break;
            }
            ref[0]--;
            if(ref[0] == 0){
                return cur;
            }
            Long next = cur * 10;
            if(next <= n){
                Long rst = generateLexi(cur*10, n, 10, ref);
                if(rst != null){
                    return rst;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(957747794,424238336));
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(681692778,351251360));
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(10, 3));
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(13, 2));
    }
}
