package com.moses.leet.n0360;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * 请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
 *
 * 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
 *
 * 你将会被给出一个 (行, 列) 形式的食物位置序列。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1。
 *
 * 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
 *
 * 当一个食物在屏幕上出现时，它被保证不能出现在被蛇身体占据的格子里。
 *
 * 对于每个 move() 操作，你需要返回当前得分或 -1（表示蛇与自己身体或墙相撞，意味游戏结束）。
 *
 * 示例：
 *
 * 给定 width = 3, height = 2, 食物序列为 food = [[1,2],[0,1]]。
 *
 * Snake snake = new Snake(width, height, food);
 *
 * 初始时，蛇的位置在 (0,0) 且第一个食物在 (1,2)。
 *
 * |S| | |
 * | | |F|
 *
 * snake.move("R"); -> 函数返回 0
 *
 * | |S| |
 * | | |F|
 *
 * snake.move("D"); -> 函数返回 0
 *
 * | | | |
 * | |S|F|
 *
 * snake.move("R"); -> 函数返回 1 (蛇吃掉了第一个食物，同时第二个食物出现在位置 (0,1))
 *
 * | |F| |
 * | |S|S|
 *
 * snake.move("U"); -> 函数返回 1
 *
 * | |F|S|
 * | | |S|
 *
 * snake.move("L"); -> 函数返回 2 (蛇吃掉了第二个食物)
 *
 * | |S|S|
 * | | |S|
 *
 * snake.move("U"); -> 函数返回 -1 (蛇与边界相撞，游戏结束)
 *
 *
 */
public class DesignSnakeGame {

    //OOM
    class SnakeGame {
        char[][] screen;
        int[][] food;
        int foodPos = 0;
        LinkedList<int[]> snake;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            screen = new char[height][width];
            for(int i=0; i<height; i++){
                Arrays.fill(screen[i], ' ');
            }
            this.food = food;
            snake = new LinkedList<>();
            snake.addFirst(new int[]{0,0});
            screen[0][0] = 'S';
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] f = null;
            if(foodPos < food.length){
                f = food[foodPos];
            }
            int[] head = snake.peekFirst();
            int[] move = next(head, direction);
            if(move[0] < 0 || move[1] < 0 || move[0] >=screen.length || move[1] >= screen[0].length){
                return -1;
            }
            if(f != null && move[0] == f[0] && move[1] == f[1]){
                snake.addFirst(move);
                foodPos++;
            }else{
                snake.addFirst(move);
                int[] rem = snake.removeLast();
                screen[rem[0]][rem[1]] = ' ';
            }
            if(screen[move[0]][move[1]] == 'S'){
                return -1;
            }
            screen[move[0]][move[1]] = 'S';
            return snake.size()-1;
        }

        int[] next(int[] head, String d){
            if("U".equals(d)){
                return new int[]{head[0]-1, head[1]};
            }else if("L".equals(d)){
                return new int[]{head[0], head[1]-1};
            }else if("R".equals(d)){
                return new int[]{head[0], head[1]+1};
            }else{
                return new int[]{head[0]+1, head[1]};
            }
        }
    }


}
