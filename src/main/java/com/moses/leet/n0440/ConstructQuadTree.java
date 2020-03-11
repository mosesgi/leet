package com.moses.leet.n0440;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        int len = grid.length;
        int first = grid[0][0];
        if(len == 1){
            return new Node(first==1, true);
        }
        boolean allSame = true;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(grid[i][j] != first){
                    allSame = false;
                    break;
                }
            }
        }
        if(allSame){
            return new Node(first == 1, true);
        }
        int mid = len/2;
        return new Node(false, false, recursive(grid, 0,0,mid-1,mid-1),
                recursive(grid, 0,mid,mid-1,len-1),
                recursive(grid, mid,0,len-1,mid-1),
                recursive(grid, mid,mid,len-1,len-1));

    }

    private Node recursive(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        int first = grid[startRow][startCol];
        if(startRow == endRow){
            return new Node(first == 1, true);
        }
        int len = endRow - startRow + 1;
        boolean allSame = true;
        for(int i=startRow; i<=endRow; i++){
            for(int j=startCol; j<=endCol; j++){
                if(grid[i][j] != first){
                    allSame = false;
                    break;
                }
            }
        }
        if(allSame){
            return new Node(first==1, true);
        }
        int mid = len/2;
        return new Node(false, false,
                recursive(grid, startRow,startCol,startRow+mid-1,startCol+mid-1),
                recursive(grid, startRow,startCol+mid,startRow+mid-1,endCol),
                recursive(grid, startRow+mid,startCol,endRow,startCol+mid-1),
                recursive(grid, startRow+mid,startCol+mid,endRow,endCol));
    }

    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][]{
                {0,1},{1,0}
        };

    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
