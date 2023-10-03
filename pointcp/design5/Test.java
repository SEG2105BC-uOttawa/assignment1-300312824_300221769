package design5;

import java.io.IOException;
import java.util.ArrayList;

import design1.PointCP;
import design2.PointCP2;
import design3.PointCP3;

public class Test {
    public static ArrayList<Long> point1Test(PointCP point1) throws IOException {
        long start, end;
        ArrayList<Long> stats = new ArrayList<>();

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.getX();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.getY();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.getRho();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.getTheta();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.getDistance(point1);
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point1.rotatePoint(i);
        }
        end = System.nanoTime();
        stats.add(end-start);

        return stats;
    }

    public static ArrayList<Long> point2Test(PointCP2 point2) throws IOException {
        long start, end;
        ArrayList<Long> stats = new ArrayList<>();

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.getX();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.getY();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.getRho();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.getTheta();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.getDistance(point2);
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point2.rotatePoint(i);
        }
        end = System.nanoTime();
        stats.add(end-start);

        return stats;
    }

    public static ArrayList<Long> point3Test(PointCP3 point3) throws IOException {
        long start, end;
        ArrayList<Long> stats = new ArrayList<>();

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.getX();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.getY();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.getRho();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.getTheta();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.getDistance(point3);
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point3.rotatePoint(i);
        }
        end = System.nanoTime();
        stats.add(end-start);

        return stats;
    }

    public static ArrayList<Long> point4Test(PointCP5 point4) throws IOException {
        long start, end;
        ArrayList<Long> stats = new ArrayList<>();

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.getX();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.getY();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.getRho();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.getTheta();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.getDistance(point4);
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point4.rotatePoint(i);
        }
        end = System.nanoTime();
        stats.add(end-start);

        return stats;
    }

    public static ArrayList<Long> point5Test(PointCP5 point5) throws IOException {
        long start, end;
        ArrayList<Long> stats = new ArrayList<>();

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.getX();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.getY();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.getRho();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.getTheta();
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.getDistance(point5);
        }
        end = System.nanoTime();
        stats.add(end-start);

        start = System.nanoTime();
        for (int i=0; i < 10000000; i++) {
            point5.rotatePoint(i);
        }
        end = System.nanoTime();
        stats.add(end-start);

        return stats;
    }
}