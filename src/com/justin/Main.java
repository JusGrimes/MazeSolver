package com.justin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Maze firstMaze;
        Scanner in = new Scanner(System.in);

        System.out.print("Rows: ");
        int rows = Integer.parseInt(in.nextLine());

        System.out.print("Cols: ");
        int cols = Integer.parseInt(in.nextLine());

        System.out.print("Density: ");
        double density = Double.parseDouble(in.nextLine());

//        firstMaze = MazeFactory.middleStartGoal(rows, cols, density);
        firstMaze = MazeFactory.createMaze("standard", rows, cols, density);
        System.out.println("Standard Maze");
        System.out.println("\n" + firstMaze);

        System.out.println("Solved Maze");

        MazeSolver solver = new MazeSolver(firstMaze.copy());
        solver.solveDFSorBFS("DFS");
        System.out.println(solver.getMaze());


    }
}
