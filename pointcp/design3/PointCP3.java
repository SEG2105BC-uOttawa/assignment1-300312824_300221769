package design3;

public class PointCP3 {
    //Instance variables
    private char typeCord;
    private double xOrRho;
    private double yOrTheta;

    //Constructors
    public PointCP3(char type, double xOrRho, double yOrTheta) {
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        typeCord = 'C';
    }

    //Instance methods **************************************************
    public double getX(){
        if(typeCord == 'C')
            return xOrRho;
        else
            return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }

    public double getY(){
        if(typeCord == 'C')
            return yOrTheta;
        else
            return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }

    public double getRho(){
        if(typeCord == 'P')
            return xOrRho;
        else
            return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }

    public double getTheta(){
        if(typeCord == 'P')
            return yOrTheta;
        else
            return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }

    public double getDistance(PointCP3 pointB){
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP3 rotatePoint(double rotation){
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString() {
        return "Stored as " + (typeCord == 'C'
                ? "Cartesian  (" + getX() + "," + getY() + ")"
                : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }
}