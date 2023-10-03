package design5;

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
public class PointCP3_1 extends PointCP5
{
    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP3_1(double x, double y) {
        super('C', x, y);
    }


    //Instance methods **************************************************


    public double getX()
    {
        return this.xOrRho;
    }

    public double getY()
    {
        return this.yOrTheta;
    }

    public double getRho()
    {
        return (Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2)));
    }

    public double getTheta()
    {
        return Math.toDegrees(Math.atan2(this.getY(), this.getX()));
    }


    public PointCP3_1 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3_1(
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Stored as Cartesian  (" + getX() + "," + getY() + ")";
    }
}