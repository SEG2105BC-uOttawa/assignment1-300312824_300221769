package design5;

import design1.PointCP;
import java.io.*;

public class PointCPTest{

  //Class methods
  public static void main(String[] args){
    PointCP point;
    System.out.println("Cartesian-Polar Coordinates Conversion Program");
    try{
      point = new PointCP(args[0].toUpperCase().charAt(0),
              Double.valueOf(args[1]).doubleValue(),
              Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e){
      if(args.length != 0) System.out.println("Invalid arguments on command line");
      try
      {
        point = getInput();
      }
      catch(IOException ex){
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("\nYou entered:\n" + point);
    point.convertStorageToCartesian();
    System.out.println("\nAfter asking to store as Cartesian:\n" + point);
    point.convertStorageToPolar();
    System.out.println("\nAfter asking to store as Polar:\n" + point);
  }

  private static PointCP getInput() throws IOException{
    byte[] buffer = new byte[1024];
    boolean isOK = false;
    String theInput = " ";

    char coordType = 'A';
    double a = 0.0;
    double b = 0.0;

    for (int i = 0; i < 3; i++){
      while (!(isOK)){
        isOK = true;  //flag set to true assuming input will be valid

        if (i == 0) System.out.print("Enter the type of Coordinates you are inputting ((C)artesian) / (P)olar): ");
        else{
          System.out.print("Enter the value of "
                  + (coordType == 'C'
                  ? (i == 1 ? "X " : "Y ")
                  : (i == 1 ? "Rho " : "Theta "))
                  + "using a decimal point(.): ");
        }

        for(int k=0; k<1024; k++) buffer[k] = ' ';

        System.in.read(buffer);
        theInput = new String(buffer).trim();
        try{
          if (i == 0){
            if (!((theInput.toUpperCase().charAt(0) == 'C')
                    || (theInput.toUpperCase().charAt(0) == 'P'))) isOK = false;
            else coordType = theInput.toUpperCase().charAt(0);
          }
          else{
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e){
          System.out.println("Incorrect input");
          isOK = false;
        }
      }
      isOK = false;
    }
    return (new PointCP(coordType, a, b));
  }
}