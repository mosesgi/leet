package com.moses.leet.n0960;

/**
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
 *
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 *
 * Return the number of regions.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [
 *   " /",
 *   "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 *
 * Example 2:
 *
 * Input:
 * [
 *   " /",
 *   "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 *
 * Example 3:
 *
 * Input:
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 *
 * Example 4:
 *
 * Input:
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 *
 * Example 5:
 *
 * Input:
 * [
 *   "//",
 *   "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 *
 *
 *
 * Note:
 *
 *     1 <= grid.length == grid[0].length <= 30
 *     grid[i][j] is either '/', '\', or ' '.
 *
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        return 0;
    }
}







/**
 解题思路

 这道题一开始摸不到头绪，后来根据一个大佬的题解（https://leetcode-cn.com/u/ma-dong-dong/），把每个格变为3*3的小格，就可以轻松用dfs、bfs算出连通分量也就是最后的答案。

 但是好不容易发现一道稀缺的并查集的题，就想练练并查集，但是发现官方对于这道题的题解并不是非常的详细，所以在基于官方题解的基础上，说一说自己理解。
 （以下内容参考于博客：https://blog.csdn.net/qq_17550379/article/details/85262219）

 1.我们可以通过/和\将一个区域划分为四块，然后我们按照顺时针自顶开始的顺序标记划分后的区域为1、2、3和4。我们此时就可以开始遍历输入的grid。
 2.如果碰到'/'，我们就将0和3进行归并。如果碰到'\'，我们就将1和2归并。如果碰到' '， 我们就将1、2、3和4全部归并。
 （此处请注意：官方题解中是上0下3左1右2，与此处不同，但是对理解思想没影响）

 */