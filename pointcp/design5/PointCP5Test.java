package design5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

import design1.PointCP;
import design2.PointCP2;
import design3.PointCP3;
import design5.PointCP5;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP5Test {
  final static String LOG_FILE = "PointCPTest_log.txt";
  final static int NUM_TESTS = 10;
  final static int NUM_METHODS = 6;

  public static void main(String[] args) throws IOException{
    double[] coords = randCoords();

    FileWriter fileWriter = new FileWriter(LOG_FILE, false);
    fileWriter.close();

    ArrayList<Long> data = new ArrayList<>();
    ArrayList<Long> point1Data = new ArrayList<>();
    ArrayList<Long> point2Data = new ArrayList<>();
    ArrayList<Long> point3Data = new ArrayList<>();
    ArrayList<Long> point4Data = new ArrayList<>();
    ArrayList<Long> point5Data = new ArrayList<>();

    for (int i=0; i < NUM_TESTS; i++) {
      PointCP point1 = new PointCP(randTypeCoords(), coords[0], coords[1]);
      PointCP2 point2 = new PointCP2(point1.getRho(), point1.getTheta());
      PointCP3 point3 = new PointCP3(point1.getX(), point1.getY());
      PointCP5 point4 = new PointCP2_1(point1.getRho(), point1.getTheta());
      PointCP5 point5 = new PointCP3_1(point1.getX(), point1.getY());

      data = Test.point1Test(point1);
      point1Data.addAll(data);
      System.out.print('.');
      logStats(data, "point1");

      data = Test.point2Test(point2);
      point2Data.addAll(data);
      logStats(data, "point2");
      System.out.print('.');

      data = Test.point3Test(point3);
      point3Data.addAll(data);
      logStats(data, "point3");
      System.out.print('.');

      data = Test.point4Test(point4);
      point4Data.addAll(data);
      logStats(data, "point4");
      System.out.print('.');

      data = Test.point5Test(point5);
      point5Data.addAll(data);
      logStats(data, "point5");
      System.out.print('.');
    }

    System.out.println("");
    printMinMedMax(point1Data, "point1");
    printMinMedMax(point2Data, "point2");
    printMinMedMax(point3Data, "point3");
    printMinMedMax(point4Data, "point4");
    printMinMedMax(point5Data, "point5");
  }

  public static double[] randCoords() {
    Random random = new Random(System.nanoTime());
    return new double[]{random.nextDouble(-1000, 1000), random.nextDouble(-1000, 1000)};
  }

  public static char randTypeCoords() {
    Random random = new Random(System.nanoTime());
    int num = random.nextInt(0,2);
    return (num == 0 ? 'C' : 'P');
  }

  public static void printStats(ArrayList<Long> stats, String objectName) {
    String method = "";
    for (int i=0; i < stats.size(); i++) {
      switch (i) {
        case 0:
          method = "get X";
          break;

        case 1:
          method = "get Y";
          break;

        case 2:
          method = "get Rho";
          break;

        case 3:
          method = "get Theta";
          break;

        case 4:
          method = "get distance";
          break;

        case 5:
          method = "rotate point";
          break;

        default:
          break;
      }
      System.out.println("Time to " + method + " of " +
              objectName + " 10000000 times: " + String.valueOf((stats.get(i))/Math.pow(10, 9)));
    }
  }

  public static void logStats(ArrayList<Long> stats, String objectName) throws IOException {
    FileWriter fileWriter = new FileWriter(LOG_FILE, true);
    String method = "";

    for (int i=0; i < stats.size(); i++) {
      switch (i) {
        case 0:
          method = "get X";
          break;

        case 1:
          method = "get Y";
          break;

        case 2:
          method = "get Rho";
          break;

        case 3:
          method = "get Theta";
          break;

        case 4:
          method = "get distance";
          break;

        case 5:
          method = "rotate point";
          break;

        default:
          break;
      }
      fileWriter.append("Time to " + method + " of " +
              objectName + " 10000000 times: " + String.valueOf((stats.get(i))/Math.pow(10, 9)) + "\n");
    }
    fileWriter.close();
  }

  public static void printMinMedMax(ArrayList<Long> stats, String objectName) {
    Iterator<Long> iterator = stats.iterator();
    int methodNum = -1;
    double seconds;

    double[] getXTimes = new double[NUM_TESTS];
    double[] getYTimes = new double[NUM_TESTS];
    double[] getRhoTimes = new double[NUM_TESTS];
    double[] getThetaTimes = new double[NUM_TESTS];
    double[] getDistanceTimes = new double[NUM_TESTS];
    double[] rotatePointTimes = new double[NUM_TESTS];

    while (iterator.hasNext()) {
      methodNum++;
      seconds = iterator.next() / Math.pow(10, 9);

      switch (methodNum % 6) {
        case 0:
          getXTimes[methodNum / 6] = seconds;
          break;

        case 1:
          getYTimes[methodNum / 6] = seconds;
          break;

        case 2:
          getRhoTimes[methodNum / 6] = seconds;
          break;

        case 3:
          getThetaTimes[methodNum / 6] = seconds;
          break;

        case 4:
          getDistanceTimes[methodNum / 6] = seconds;
          break;

        case 5:
          rotatePointTimes[methodNum / 6] = seconds;
          break;

        default:
          break;
      }
    }

    Arrays.sort(getXTimes);
    Arrays.sort(getYTimes);
    Arrays.sort(getRhoTimes);
    Arrays.sort(getThetaTimes);
    Arrays.sort(getDistanceTimes);
    Arrays.sort(rotatePointTimes);

    System.out.println(objectName);
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "getX()", getXTimes[0], getXTimes[NUM_TESTS/2], getXTimes[NUM_TESTS-1]));
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "getY()", getYTimes[0], getYTimes[NUM_TESTS/2], getYTimes[NUM_TESTS-1]));
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "getRho()", getRhoTimes[0], getRhoTimes[NUM_TESTS/2], getRhoTimes[NUM_TESTS-1]));
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "getTheta()", getThetaTimes[0], getThetaTimes[NUM_TESTS/2], getThetaTimes[NUM_TESTS-1]));
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "getDistance()", getDistanceTimes[0], getDistanceTimes[NUM_TESTS/2], getDistanceTimes[NUM_TESTS-1]));
    System.out.println(String.format("%s    Min: %s    Median: %s    Max: %s", "rotatePoint()", rotatePointTimes[0], rotatePointTimes[NUM_TESTS/2], rotatePointTimes[NUM_TESTS-1]));
    System.out.println();
  }
}