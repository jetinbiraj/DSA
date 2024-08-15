package com.app.google;

import java.util.List;

public class Playground {


    public static void main(String[] args) {
        List<String> commands = List.of("DOWN", "RIGHT", "UP");
        int n = 3;

        System.out.println(finalPositionOfSnake(n, commands));
    }

    public static int finalPositionOfSnake(int n, List<String> commands) {

        int i = 0;
        int j = 0;

        for (String command : commands) {

            switch (command) {
                case "UP":
                    i -= 1;
                    break;
                case "RIGHT":
                    j += 1;
                    break;
                case "DOWN":
                    i += 1;
                    break;
                case "LEFT":
                    j -= 1;
                    break;
            }
        }

        return (i * n) + j;
    }
}
