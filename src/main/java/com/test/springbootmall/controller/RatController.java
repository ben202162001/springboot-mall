package com.test.springbootmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

@RestController
public class RatController {
    public static java.util.Stack<String> path = new java.util.Stack<String>();
    public static int c = 1;

    public String rat_run(){

        String result ="";
        int maze[][] = new int[12][12];
        ready_maze(maze);
        int x = 10;
        int y = 10;
        if (maze[1][1] == 1) {
            System.out.println("No exit");
        } else if (findpath(maze) == true) {
            for (int k = 1; k < 11; k++) {
                for (int l = 1; l < 11; l++) {
                    maze[k][l] = 1;
                }
            }
            while (path.empty() != true) {
                System.out.println(c + "(" + x + "," + y + ")");
                c--;
                maze[x][y] = 0;
                String p = path.pop();
                if (p.equals("right")) {
                    y--;
                } else if (p.equals("down")) {
                    x--;
                } else if (p.equals("left")) {
                    y++;
                } else if (p.equals("up")) {
                    x++;
                }
            }
            System.out.println(c + "(1,1)");
            maze[1][1] = 0;
            System.out.println();
            for (int k = 1; k < 11; k++) {
                for (int l = 1; l < 11; l++) {
                    if (maze[k][l] == 1) {
                        System.out.print("- ");
                        result = result + "格 ";
                    } else {
                        System.out.print("* ");
                        result = result + "走 ";
                    }
                }
                System.out.println();
                //dom讀的換行號是<br>
                result = result + "<br>";
            }
        } else {
            System.out.print("No exit");
        }
        return result;
    }
    private void ready_maze(int maze[][]){
        int n = 12;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == 0 || i == 11)
                    maze[i][j] = 1;
                if (j == 0 || j == 11)
                    maze[i][j] = 1;
            }
        }
        try {
            File file = new File("D:\\ds.txt");
            //File file = new File("../resources/ds.txt");
            Scanner input = new Scanner(file);

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    maze[i][j] = input.nextInt();
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println(" ");
            }
        } catch (FileNotFoundException e1) {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    maze[i][j] = 0;
                }
                System.out.println(" ");
            }
        }
    }


    private static boolean findpath(int maze[][]) {
        int a = 1;
        int b = 1;
        while (a != 10 || b != 10) {
            maze[a][b] = 1;
            if (maze[a][b + 1] == 0) {
                path.push("right");
                b++;
                c++;
            } else if (maze[a + 1][b] == 0) {
                path.push("down");
                a++;
                c++;
            } else if (maze[a][b - 1] == 0) {
                path.push("left");
                b--;
                c++;
            } else if (maze[a - 1][b] == 0) {
                path.push("up");
                a--;
                c++;
            } else {
                if (path.empty() == true) {
                    return false;
                }
                String retry = path.pop();
                if (retry.equals("right")) {
                    b--;
                    c--;
                } else if (retry.equals("down")) {
                    a--;
                    c--;
                } else if (retry.equals("left")) {
                    b++;
                    c--;
                } else if (retry.equals("up")) {
                    a++;
                    c--;
                }
            }
        }
        return true;
    }
    @RequestMapping("/rat")
    public String rat() {
        return rat_run();
    }
}
