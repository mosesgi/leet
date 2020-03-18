package com.moses.leet.n0480;

import java.util.Random;

public class GenerateRandomPointInCircle {
    class Solution {
        double radius;
        double x;
        double y;
        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            double len = Math.sqrt(Math.random()) * radius;
            double deg = 360 * Math.random();
            double xp = len * Math.cos(Math.toRadians(deg));
            double yp = len * Math.sin(Math.toRadians(deg));

            return new double[]{x+xp, y+yp};
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.sin(Math.toRadians(30)));
    }
}
