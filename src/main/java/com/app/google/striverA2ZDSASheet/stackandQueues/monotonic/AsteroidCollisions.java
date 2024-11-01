package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.*;

public class AsteroidCollisions {

    public static void main(String[] args) {

        int[] asteroids = {10, 2, -5};

        System.out.println(Arrays.toString(bruteForceAsteroidCollision(asteroids)));
        System.out.println(Arrays.toString(betterAsteroidCollision(asteroids)));
    }

    private static int[] betterAsteroidCollision(int[] asteroids) {

        List<Integer> list = new ArrayList<>();

        for (int num : asteroids) {

            if (num > 0) {
                list.add(num);
            } else {

                int absNum = Math.abs(num);

                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < absNum) {
                    list.removeLast();
                }

                if (list.isEmpty() || list.getLast() < absNum) {
                    list.add(num);
                } else if (list.getLast() == absNum) {
                    list.removeLast();
                }
            }
        }

        int[] collisions = new int[list.size()];
        int index = 0;
        for (int num : list) {
            collisions[index++] = num;
        }

        return collisions;
    }

    private static int[] bruteForceAsteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int num : asteroids) {

            if (num > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(num);
            } else {

                int absNum = Math.abs(num);

                while (!stack.isEmpty() && stack.peek() < absNum && stack.peek() > 0) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < absNum) {
                    stack.push(num);
                } else if (stack.peek() == absNum) {
                    stack.pop();
                }
            }
        }

        Collections.reverse(stack);

        int[] collisions = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            collisions[index++] = stack.pop();
        }

        return collisions;
    }
}
