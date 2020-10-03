// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

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
public class PointCP4
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char type; 
  
  /**
   * Contains the current value of X and Y depending on the type
   * of coordinates.
   */
  private double x;
  private double y;
  /**
   * Contains the current value of RHO and THETA value depending on the
   * type of coordinates.
   */
  private double theta;
  private double rho;
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP4(char type, double xOrRho, double yOrTheta)
  {
    if(type != 'C' && type != 'P'){
      throw new IllegalArgumentException();
	}
	
	else if (type=='C'){
		this.type = type;
		this.x = xOrRho;
		this.y = yOrTheta;
		this.rho= (Math.sqrt(Math.pow(x, 2) + Math.pow(y,2)));
		this.theta= Math.toDegrees(Math.atan2(y,x));
	}
	else {
		this.type = type;
		this.rho = xOrRho;
		this.theta = yOrTheta;
		this.x= (Math.cos(Math.toRadians(theta)) * rho);
		this.y= (Math.sin(Math.toRadians(theta)) * rho);
	}
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
    
      return rho;
  }
  
  public double getTheta()
  {
    
      return theta;
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  //public void convertStorageToPolar()
  //{
   // if(typeCoord != 'P')
   // {
      //Calculate RHO and THETA
     // double temp = getRho();
     // yOrTheta = getTheta();
      //xOrRho = temp;
      
     // typeCoord = 'P';  //Change coord type identifier
    //}
  //}
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  //public void convertStorageToCartesian()
  //{
    //if(typeCoord != 'C')
    //{
      //Calculate X and Y
      //double temp = getX();
      //yOrTheta = getY();
      //xOrRho = temp;
   
      //typeCoord = 'C';	//Change coord type identifier
    //}
  //}

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP('C',
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
    return "Cartesian : (" + getX() + "," + getY() + ")"+ "\n"+"Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}
