package com.lasseu;

import java.util.*;

// This is an example of how to do a topolocical sort using BFS.

public class topSort extends simpleGraph {

    int indegree[];

    public topSort(String fileName){
        super(fileName);
    }

    public void findAndPrint(){

        indegree = new int[n];

        System.out.println("\nTopological sorted:\n");

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (adj[i][j] && i != j){
                    indegree[j]++;
                }
            }
        }

        Stack<Integer> S = new Stack<>();

        for (int i = 0; i < n; i++){
            if (indegree[i]==0){
                S.push(i);
            }
        }

        while (!S.isEmpty()){

            int u = S.pop();
            System.out.print(data[u] + " ");

            for (int v = 0; v < n; v++){
                if (adj[u][v] && indegree[v] != 0){
                    indegree[v]--;
                    if (indegree[v]==0){
                        S.push(v);
                    }
                }
            }
        }
        System.out.println("\n\n");
    }
}