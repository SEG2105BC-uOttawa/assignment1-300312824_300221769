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
public class PointCP2 extends PointCP5
{

    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP2(char type, double xOrRho, double yOrTheta)
    {
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        typeCord = type;
    }


    //Instance methods **************************************************

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param // The point to rotate
     * @param rotation Th    e number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP5 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP2('C',
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
        return ("Stored as Polar [" + getRho() + "," + getTheta() + "]" + "\n");
    }
}