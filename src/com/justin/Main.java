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

        firstMaze = MazeFactory.standardMaze(rows, cols, density);
        System.out.println("Standard Maze");
        System.out.println("\n" + firstMaze);
//        System.out.println("Open Maze");
//        System.out.println("\n" + MazeFactory.openMaze(rows, cols));
//        System.out.println("Closed Maze");
//        System.out.println("\n" + MazeFactory.closedMaze(rows, cols));

    }
}
