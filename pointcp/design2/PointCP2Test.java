package design2;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP2Test
{
    //Class methods *****************************************************

    /**
     * This method is responsible for the creation of the PointCP2
     * object.  This can be done in two ways; the first, by using the
     * command line and running the program using <code> java
     * PointCP2Test &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
     * </code> and the second by getting the program to prompt the user.
     * If the user does not enter a valid sequence at the command line,
     * the program will prompte him or her.
     *
     * @param //args[0] The coordinate type.  P for polar and C for
     *                cartesian.
     * @param //rgs[1] The value of X or RHO.
     * @param //args[2] The value of Y or THETA.
     */
    public static void main(String[] args)
    {
        PointCP2 point;
        Random r = new Random();

        long start, finish, minTime, maxTime, totalTime;
        double rotate, x, y;
        minTime = 1000;
        maxTime = 0;
        totalTime = 0;
        for(int i = 0; i < 1000; i++){
            start = System.currentTimeMillis();

            x = 1000 * r.nextDouble();
            y = 1000 * r.nextDouble();
            rotate = 360 * r.nextDouble();
            point = new PointCP2('P', x, y);

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

            x = 1000 * r.nextDouble();
            y = 1000 * r.nextDouble();
            rotate = 360 * r.nextDouble();
            point = new PointCP2('P', x, y);
            PointCP2 pointB = new PointCP2('C', 1000*r.nextDouble(), 1000*r.nextDouble());

            point.getDistance(pointB);

            finish = System.currentTimeMillis();

            totalTime = totalTime + finish - start;
            if((finish - start) < minTime){
                minTime = finish - start;
            }

            if((finish - start) > maxTime){
                maxTime = finish - start;
            }
        }

        System.out.println("Distance test");
        System.out.println("Max time = " + maxTime);
        System.out.println("Min time = " + minTime);
        System.out.println("Total time = " + totalTime);

    }

    /**
     * This method obtains input from the user and verifies that
     * it is valid.  When the input is valid, it returns a PointCP2
     * object.
     *
     * @return A PointCP2 constructed using information obtained
     *         from the user.
     * @throws IOException If there is an error getting input from
     *         the user.
     */
    private static PointCP2 getInput() throws IOException
    {
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'P'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 1; i < 3; i++)
        {
            while (!(isOK))
            {
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if (i == 0) // First argument - type of coordinates
                {
                    System.out.print("Enter the type of Coordinates you "
                            + "are inputting ((C)artesian / (P)olar): ");
                }
                else // Second and third arguments
                {
                    System.out.print("Enter the value of "
                            + (coordType == 'C'
                            ? (i == 1 ? "X " : "Y ")
                            : (i == 1 ? "Rho " : "Theta "))
                            + "using a decimal point(.): ");
                }

                // Get the user's input

                // Initialize the buffer before we read the input
                for(int k=0; k<1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try
                {
                    if (i == 0) // First argument -- type of coordinates
                    {
                        if (!((theInput.toUpperCase().charAt(0) == 'C')
                                || (theInput.toUpperCase().charAt(0) == 'P')))
                        {
                            //Invalid input, reset flag so user is prompted again
                            isOK = false;
                        }
                        else
                        {
                            coordType = theInput.toUpperCase().charAt(0);
                        }
                    }
                    else  // Second and third arguments
                    {
                        //Convert the input to double values
                        if (i == 1)
                            a = Double.valueOf(theInput).doubleValue();
                        else
                            b = Double.valueOf(theInput).doubleValue();
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Incorrect input");
                    isOK = false;  //Reset flag as so not to end while loop
                }
            }

            //Reset flag so while loop will prompt for other arguments
            isOK = false;
        }
        //Return a new PointCP2 object
        return (new PointCP2(coordType, a, b));
    }
}