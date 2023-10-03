package design2;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP2
{
    //Instance variables ************************************************
    /**
     * Contains the current value of RHO
     */
    private double rho;

    /**
     * Contains the current value of THETA
     */
    private double theta;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP2(double rho, double theta)
    {
        this.rho = rho;
        this.theta = theta;
    }


    //Instance methods **************************************************


    public double getX()
    {
        return (Math.cos(Math.toRadians(theta)) * rho);
    }

    public double getY()
    {

        return (Math.sin(Math.toRadians(theta)) * rho);
    }

    public double getRho()
    {
        return rho;
    }

    public double getTheta()
    {
        return theta;
    }


    public double getDistance(PointCP2 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }


    public PointCP2 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
        double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

        double newRho = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
        double newTheta = Math.toDegrees(Math.atan2(newY, newX));

        return new PointCP2(newTheta, newRho);
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Stored as Polar [" + getRho() + "," + getTheta() + "]";
    }
}