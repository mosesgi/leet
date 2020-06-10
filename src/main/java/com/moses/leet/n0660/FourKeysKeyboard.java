package com.moses.leet.n0660;

import java.util.HashMap;
import java.util.Map;

/**
 * Imagine you have a special keyboard with the following keys:
 *
 * Key 1: (A): Print one 'A' on screen.
 *
 * Key 2: (Ctrl-A): Select the whole screen.
 *
 * Key 3: (Ctrl-C): Copy selection to buffer.
 *
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
 *
 * Example 1:
 *
 * Input: N = 3
 * Output: 3
 * Explanation:
 * We can at most get 3 A's on screen by pressing following key sequence:
 * A, A, A
 *
 * Example 2:
 *
 * Input: N = 7
 * Output: 9
 * Explanation:
 * We can at most get 9 A's on screen by pressing following key sequence:
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 *
 * Note:
 *
 *     1 <= N <= 50
 *     Answers will be in the range of 32-bit signed integer.
 *
 */
public class FourKeysKeyboard {

    /**
     * 消除状态
     *
     * 对于第 N 次按键，增加 A 会有两种方式：
     * 1. A(key1)
     * 2. 复制(key4)。
     *
     * 1 不必多说，对于 2 我们需要知道 “第 N - 1 次缓冲区为 k 时，已经得到 A 的最大数量为 C”，那么第 N 次 A 个数 = C + k.
     * 由此我们可以想到dp 状态转移方程: f[i][k] ，表示第 i 次按键缓冲区为 k 时，已经得到 A 的最大数量。
     *
     * 但这里有两个问题:
     * 1. key2 和 key3 决定了 k 的数值，我们还需要增加一个状态f[i][k][s]，表示已经选中了 s 个 A 么？
     * 2. k 的值会非常大，当做一个状态几乎是不可能的。
     *
     * 对于1，假如增加s后，状态方程是什么样子: f[i][k][s] 表示第 i 次按键缓冲区为 k ，选中 A 为 s 时，得到 A 的最大数量。
     *
     * 尝试优化状态，减少状态
     * 直觉上，key2/key3/key4 要连着按，接下来证明下：
     * 假如 ...key2 + key1 + key3 + key4 ，那么一定可以换成 ...key1 + key2 + key3 + key4，并且局面更优，最后得到A数量更多
     * 假如 ...key2 + key3 + key1 + key4 ，那么一定可以换成 ...key1 + key2 + key3 + key4，并且局面更优，最后得到A数量更多
     *
     * 因为要求 N 次按键得到 A 的最大数量，所以我们可以把 key2/key3/key4 看成连着按。
     * 这样的话，f[i][k][s] 里的 s，选中多少个A 就没有存在的必要了，因为选中后立刻放入缓冲区，即变为 f[i][k].
     *
     * 但还存在问题2，k 值非常大，该如何解决？
     * s 之所以存在，是因为放入缓冲区后，还可以 key4 + key1... + key4 这样的按。假如按完key3 后，立刻按key4 几次是最优情况，而不是夹杂 key1，我们就能消除 s 这个状态。
     *
     * 可以证明，假如 key4 得到至少一个key1，那么可以用连按 key4 替换 key1 key4 交替按，局面是更优的，至少不会更差。
     *
     * 所以 f[i][s] => f[i]: 表示前 i 次按键最大 A 的数量。
     *
     * 现在确定的只是从哪个点开始进行 复制(key4) 这个操作，可以从前面第三个点开始遍历，更新f[i]值（从3开始是因为前面有两次key2,key3）。
     * 状态转移方程
     *
     * State: f[n] = max {f[n - 1] + 1, f[j-3] * (i - j + 2)} j>=3 & j <=i
     * init: f[0] = 0
     * answer: f[N]
     * 顺序: 递增
     *
     * 例如 A A A key2 key3 key4 key 4 , f[j-3] * (i - j + 2) 表示对前 3 个 A * 3
     *
     * @param N
     * @return
     */
    public int maxA(int N) {
        int[] f = new int[N + 1];
        f[0] = 0;
        int i, j;

        for(i = 1; i <= N; i++) {
            f[i] = f[i - 1] + 1;
            for(j = 3; j <= i; j++) { // j 表示 copy 点
                f[i] = Math.max(f[i], f[j - 3] * (i - j + 2));
            }
        }

        return f[N];
    }



    Map<String, Integer> mem = new HashMap<>();
    public int maxATLE(int N) {
        return dfs(N,  0, 0);
    }


    int dfs(int N, int as, int copyAs){
        if(N==0){
            return as;
        }
        String key = N+"_"+as+"_"+copyAs;
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        int a = dfs(N-1, as+1, copyAs);
        int b = 0;
        if(N>3){
            b = dfs(N-3, as*2, as);
        }
        int c = dfs(N-1, as+copyAs, copyAs);

        mem.put(key, Math.max(a, Math.max(b, c)));
        return mem.get(key);
    }

//    void dfs(int N, int n, int as, int copyAs, int prevPress){
//        if(n==N){
//            res = Math.max(res, as);
//            return;
//        }
//        if(prevPress == 0){
//            dfs(N, n + 1, as + 1, copyAs,1);
//        }else if(prevPress == 1) {
//            dfs(N, n + 1, as + 1, copyAs,1);
//            dfs(N, n + 1, as, copyAs,2);
//            dfs(N, n + 1, as + copyAs, copyAs,4);
//        }else if(prevPress == 2){
//            dfs(N, n + 1, as, as,3);
//        }else if(prevPress == 3){
//            dfs(N, n + 1, as+copyAs, as,4);
//        }else if(prevPress == 4){
//            dfs(N, n + 1, as+1, copyAs,1);
//            dfs(N, n + 1, as, copyAs,2);
//            dfs(N, n + 1, as+copyAs, copyAs,4);
//        }
//    }

}
