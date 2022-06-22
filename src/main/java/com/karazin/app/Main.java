package com.karazin.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double y0, h;
        System.out.println("Initial condition:");
        y0 = in.nextInt();

        double a = y0, b = y0 + 2;
        System.out.println("Initial range value:");
        System.out.println(a);
        System.out.println("Target range value:");
        System.out.println(b);
        System.out.println("Step:");
        h = in.nextDouble();
        System.out.println("\nEuler method:");
        countEuler(a, y0, b, h);
        System.out.println("\nRunge-Kutta method:");
        countRunge_Kutt(a, y0, b, h);
    }

    public static double func(double x, double y) {
        return  (0.6 + Math.pow(y, 2)) * x + 0.2 * y;
    }

    public static double countEuler(double a, double y0, double b, double h) {
        int n = (int) ((b - a) / h);
        double[] x = new double[n + 2];
        double[] y = new double[n + 2];
        y[0] = y0;
        for (int i = 0; i <= n; i++) {
            x[i] = a + i * h;
            y[i + 1] = y[i] + h * func(x[i], y[i]);
            System.out.println("N: "+  i + "\n" + "xi = " + x[i] + "\n" + "yi = " + y[i] + "\n" + "f(xi,yi) = "
                    + func(x[i], y[i]) + "\n" + "hf(xi,yi) = "+ func(x[i], y[i]));

        }
        return 0;
    }

    public static double countRunge_Kutt(double a, double y0, double b, double h) {
        int n = (int) ((b - a) / h);

        double[] x = new double[n + 2];
        double[] k1 = new double[n + 2];
        double[] k2 = new double[n + 2];
        double[] k3 = new double[n + 2];
        double[] k4 = new double[n + 2];
        double[] y = new double[n + 2];
        y[0] = y0;
        for (int i = 0; i <= n; i++) {
            x[i] = a + i * h;
            k1[i] = func(x[i], y[i]);
            k2[i] = func(x[i] + h / 2.0, y[i] + (h / 2.0) * k1[i]);
            k3[i] = func(x[i] + h / 2.0, y[i] + (h / 2.0) * k2[i]);
            k4[i] = func(x[i] + h, y[i] + h * k3[i]);
            y[i + 1] = y[i] + h * (k1[i] + 2 * k2[i] + 2 * k3[i] + k4[i]) / 6.0;
            System.out.println("N: "+  i + "\n"  + "xi = " + x[i] + "\n" + "yi = " + y[i] + "\n" + "k1 = " + k1[i] + "\n" +  "k2 = "
                    +  k2[i] + "\n" + "k3 = " +  k3[i] + "\n"+ "k4 = " + k4[i]);
            System.out.println("------------------------");
        }
        return 0;
    }

}
