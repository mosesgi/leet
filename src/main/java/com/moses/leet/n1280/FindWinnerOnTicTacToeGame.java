package com.moses.leet.n1280;

public class FindWinnerOnTicTacToeGame {

    //copy from discussion.
    public String tictactoe(int[][] moves) {
        int[][] checkerboard = new int[3][3];       //棋盘3*3
        boolean addA = true;                    //是否A走棋
        for (int[] move : moves) {
            int setNum = addA ? 1 : 2;          //A走棋时，设置棋盘值为1;B走棋时，设置棋盘值为2
            checkerboard[move[0]][move[1]] = setNum;        //给棋盘赋值
            if (hasFinished(checkerboard, move, setNum)) {  //检测是否结束了
                return setNum == 1 ? "A" : "B";
            }
            addA = !addA;               //交换走棋
        }
        return moves.length < 9 ? "Pending" : "Draw";
    }

    public boolean hasFinished(int[][] checkerboard, int[] move, int setNum) {
        //检查同一行的
        int tempCount = 0;
        for (int i = 0; i < 3; i++) {
            if (checkerboard[move[0]][i] != setNum) {
                tempCount = 0;
                break;
            } else {
                tempCount++;
            }
        }
        if (tempCount >= 3) {
            return true;
        }
        //检查同一列的
        for (int i = 0; i < 3; i++) {
            if (checkerboard[i][move[1]] != setNum) {
                tempCount = 0;
                break;
            } else {
                tempCount++;
            }
        }
        if (tempCount >= 3) {
            return true;
        }
        //检查对角线
        if (checkerboard[1][1] == setNum) {
            if ((checkerboard[0][0] == setNum && checkerboard[2][2] == setNum)
                    || (checkerboard[2][0] == setNum && checkerboard[0][2] == setNum)) {
                return true;
            }
        }
        return false;
    }

}
