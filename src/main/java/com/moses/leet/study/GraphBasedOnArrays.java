package com.moses.leet.study;

import java.util.*;

public class GraphBasedOnArrays {
    private final int MAX_VERTS = 20;
    private String[] vertex;        //顶点数组
    private int[][] adjMatrix;      //邻接矩阵
    private Map<String, Integer> visited = new LinkedHashMap<>();       //保存访问过的节点与起点距离
    private int nVerts = 0;

    public GraphBasedOnArrays(){
        vertex = new String[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        for(int i=0; i<MAX_VERTS; i++){
            for(int j= 0; j<MAX_VERTS; j++){
                adjMatrix[i][j] = 0;
            }
        }
        nVerts = 0;
    }

    public void addVertex(String s){
        vertex[nVerts++] = s;
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public int getUnvisitedVertex(int r){
        for(int i=0;i<MAX_VERTS; i++){
            if(adjMatrix[r][i] == 1 && !visited.containsKey(vertex[i])){
                return i;
            }
        }
        return -1;
    }

    public void displayDistance(){
        Set<String> set = visited.keySet();
        for(String s: set){
            System.out.println(s + ": " + visited.get(s));
        }
    }

    public void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(0);
        visited.put(vertex[0], level);
        int next;
        while(!queue.isEmpty()){
            Integer i = queue.poll();
            level = visited.get(vertex[i]) + 1;
            while((next = getUnvisitedVertex(i)) != -1){
                visited.put(vertex[next], level);
                queue.offer(next);
            }
            System.out.print(vertex[i] + " ");
        }
        System.out.println();

        displayDistance();
    }

    public void DFS(){
        Stack<Integer> stack = new Stack<>();
        int level = 0;
        stack.push(0);
        visited.put(vertex[0], level);
        int next;
        while(!stack.isEmpty()){
            int i = stack.pop();
            level = visited.get(vertex[i]) + 1;
            while((next = getUnvisitedVertex(i)) != -1){
                stack.push(next);
                String curr = vertex[next];
                visited.put(curr, level);
            }

            System.out.println(vertex[i] + " ");
        }

        displayDistance();
    }

    public static void main(String[] args) {
        GraphBasedOnArrays graph = new GraphBasedOnArrays();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

//        graph.BFS();
        graph.DFS();
    }
}
