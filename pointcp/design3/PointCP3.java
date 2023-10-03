package design3;


public class PointCP3
{
    //Instance variables ************************************************

    /**
     * Contains the current value of X
     */
    private double x;

    /**
     * Contains the current value of Y
     */
    private double y;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP3(double x, double y) {
        this.x = x;
        this.y = y;
    }


    //Instance methods **************************************************


    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRho()
    {
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double getTheta()
    {
        return Math.toDegrees(Math.atan2(y, x));
    }


    public double getDistance(PointCP3 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP3 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3(
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }


    public String toString()
    {
        return "Stored as Cartesian  (" + getX() + "," + getY() + ")";
    }
}