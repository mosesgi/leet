package com.moses.leet.n1060;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 *
 *     "G": go straight 1 unit;
 *     "L": turn 90 degrees to the left;
 *     "R": turn 90 degress to the right.
 *
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 *
 * Example 2:
 *
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 *
 * Example 3:
 *
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 *
 *
 * Note:
 *
 *     1 <= instructions.length <= 100
 *     instructions[i] is in {'G', 'L', 'R'}
 *
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if (!(instructions.length() >= 1 && instructions.length() <= 100)) return false;
        int d = 0;  //四个方向 0上1右2下3左  这样定是为了满足 d+1就是向左转 d+3就是向右转
        int[] dx = {0, 1, 0, -1};//索引和方向对应
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        for (char eachIns: instructions.toCharArray()) {
            switch (eachIns) {
                case 'R':
                    d += 1;
                    break;
                case 'L':
                    d += 3; //不用d-=1 是因为当d变成负数的时候，取mod会出错
                    break;
                case 'G':
                    d = d % 4;
                    x = x + dx[d];
                    y = y + dy[d];
                    break;
            }
        }
        return ((x == 0 && y == 0) || d % 4 != 0);

    }
}








/**
 一起来简化一下问题，一顿指令之后，位置从(0,0)到了(x,y)，其实可以把整个指令看成一步(0,0)->(x,y)
 接下来第二次指令会怎么走呢，很简单，如果(x,y)等于(0,0)，那么相当于整体位移为0，自然是回去了，其余情况，保持第一轮操作位移的长度，方向有4种:
 如果初始方向是向上，现在变成了向左，那么整体位移的方向向左偏转，就像例子里面的“GL”
 如果现在变成向右，整体向右偏转，就像GR”
 如果现在变成向下，整体旋转180度，就像“GRR”，直接下一次就走回去了，这三种情况，最后都能回去
 而当现在方向变成向上，那么就保持位移方向不变，就像例子里面的“GG”一样，一去不复返
 所以，总而言之，一次指令之后，只有(x,y)不是原点，并且方向和原来的方向一致，最后才回不去

 作者：yongyaoduan
 链接：https://leetcode-cn.com/problems/robot-bounded-in-circle/solution/zhi-zhi-yuan-li-yi-bu-dao-wei-shuang-100suan-fa-by/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */