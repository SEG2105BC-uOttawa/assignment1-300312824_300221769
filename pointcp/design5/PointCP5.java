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
abstract class PointCP5
{
    //Instance variables
    protected char typeCord;
    protected double xOrRho;
    protected double yOrTheta;

    //Instance methods **************************************************
    public double getX() {
        if(typeCord == 'C') return xOrRho;
        else return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }

    public double getY(){
        if(typeCord == 'C') return yOrTheta;
        else return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }

    public double getRho(){
        if(typeCord == 'P') return xOrRho;
        else return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }

    public double getTheta(){
        if(typeCord == 'P') return yOrTheta;
        else return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }

    public double getDistance(PointCP5 pointB){
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public abstract PointCP5 rotatePoint(double rotation);

    public abstract String toString();
}