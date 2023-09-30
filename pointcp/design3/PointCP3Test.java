package design3;

import java.io.*;
import java.util.Random;

public class PointCP3Test{

    //Class methods
    public static void main(String[] args){
        PointCP3 point;
        Random randomnum = new Random();

        long start, finish, minTime, maxTime, totalTime;
        double rotate, x, y;
        minTime = 1000;
        maxTime = 0;
        totalTime = 0;
        for(int i = 0; i < 1000; i++){
            start = System.currentTimeMillis();
            x = 1000 * randomnum.nextDouble();
            y = 1000 * randomnum.nextDouble();
            rotate = 360 * randomnum.nextDouble();
            point = new PointCP3('P', x, y);
            point.rotatePoint(rotate);
            finish = System.currentTimeMillis();
            totalTime = totalTime + finish - start;
            if((finish - start) < minTime){
                minTime = finish - start;
            }
            if((finish - start) > maxTime){
                maxTime = finish - start;
            }
        }
        System.out.println("Rotate test");
        System.out.println("Max time = " + maxTime);
        System.out.println("Min time = " + minTime);
        System.out.println("Total time = " + totalTime);

        minTime = 1000;
        maxTime = 0;
        totalTime = 0;
        for(int i = 0; i < 1000; i++){
            start = System.currentTimeMillis();
            x = 1000 * randomnum.nextDouble();
            y = 1000 * randomnum.nextDouble();
            rotate = 360 * randomnum.nextDouble();
            point = new PointCP3('P', x, y);
            PointCP3 pointB = new PointCP3('C', 1000*randomnum.nextDouble(), 1000*randomnum.nextDouble());
            point.getDistance(pointB);
            finish = System.currentTimeMillis();
            totalTime = totalTime + finish - start;
            if((finish - start) < minTime){
                minTime = finish - start;
            }
            if((finish - start) > maxTime) maxTime = finish - start;

        }
        System.out.println("Distance test");
        System.out.println("Max time = " + maxTime);
        System.out.println("Min time = " + minTime);
        System.out.println("Total time = " + totalTime);
    }

    private static PointCP3 getInput() throws IOException{
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char cordType = 'C'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 1; i < 3; i++){
            while (!(isOK)){
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if (i == 0){
                    System.out.print("Enter the type of Coordinates you "
                            + "are inputting ((C)artesian / (P)olar): ");
                }
                else {
                    System.out.print("Enter the value of "
                            + (cordType == 'C'
                            ? (i == 1 ? "X " : "Y ")
                            : (i == 1 ? "Rho " : "Theta "))
                            + "using a decimal point(.): ");
                }
                for(int k=0; k<1024; k++)
                    buffer[k] = ' ';
                System.in.read(buffer);
                theInput = new String(buffer).trim();
                try{
                    if (i == 0){
                        if (!((theInput.toUpperCase().charAt(0) == 'C')
                                || (theInput.toUpperCase().charAt(0) == 'P'))) isOK = false;
                        else cordType = theInput.toUpperCase().charAt(0);

                    }
                    else{
                        if (i == 1) a = Double.valueOf(theInput).doubleValue();
                        else b = Double.valueOf(theInput).doubleValue();
                    }
                }
                catch(Exception e){
                    System.out.println("Incorrect input");
                    isOK = false;  //Reset flag as so not to end while loop
                }
            }
            isOK = false;
        }
        return (new PointCP3(cordType, a, b));
    }
}