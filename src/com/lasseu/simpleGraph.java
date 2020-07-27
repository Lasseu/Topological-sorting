package com.lasseu;
import java.io.*;
import java.util.Scanner;

// The code beneath is a modified version of code written by Jan Høiberg @ HiØ

public class simpleGraph {
    int n;              // Number of vertices
    boolean[][] adj;   // Adjacency matrices
    String[] data;      // Data in nodes

    // Constructor reads data from fle
    public simpleGraph(String fileName) {
        read(fileName);
    }

    public simpleGraph() {}

    // Method that returns nmbr of nodes
    public int numberOfNodes() {
        return n;
    }


    public void read(String fileName) {
        // Graph data format:
        // <nmbr of nodes>
        // <node nmbr.> <data> <nmbr of adj> <adj nmbr> <adj nmbr> ...
        // <node nmbr.> <data> <nmbr of adj> <adj nmbr> <adj nmbr> ...

        try {
            Scanner in = new Scanner(new File(fileName));

            n = in.nextInt();

            // arrays for the graph
            adj = new boolean[n][n];
            data = new String[n];

            // Set adj matrix as false
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    adj[i][j] = i == j;


            // Reads data for each node
            for (int i = 0; i < n; i++) {
                int nodeNr = in.nextInt();
                data[nodeNr] = in.next();
                int nmbrAdj = in.nextInt();

                // Adds the adj to adj matrices
                for (int j = 0; j < nmbrAdj; j++) {
                    int naboNr = in.nextInt();
                    adj[nodeNr][naboNr] = true;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}