package frc.robot;

/** 
  *  ========================================================
  *  Vector.java: Source code for two-dimensional vectors
  * 
  *  Written by: Mark Austin                   November, 2005
  *  ========================================================
  */

  import java.lang.Math;

  public class Vector {
  
     public double dX;
     public double dY;
  
     // Constructor methods ....
  
     public Vector() {
        dX = dY = 0.0;
     }
  
     public Vector( double dX, double dY ) {
        this.dX = dX;
        this.dY = dY;
     }
  
     // Convert vector to a string ...
      
     public String toString() {
        return "Vector(" + dX + ", " + dY + ")";
     }
  
     // Compute magnitude of vector ....
   
     public double length() {
        return Math.sqrt ( dX*dX + dY*dY );
     }
  
     // Sum of two vectors ....
  
     public Vector add( Vector v1 ) {
         Vector v2 = new Vector( this.dX + v1.dX, this.dY + v1.dY );
         return v2;
     }
  
     // Subtract vector v1 from v .....
  
     public Vector sub( Vector v1 ) {
         Vector v2 = new Vector( this.dX - v1.dX, this.dY - v1.dY );
         return v2;
     }
  
     // Scale vector by a constant ...
  
     public Vector scale( double scaleFactor ) {
         Vector v2 = new Vector( this.dX*scaleFactor, this.dY*scaleFactor );
         return v2;
     }
  
     // Normalize a vectors length....
  
     public Vector normalize() {
        Vector v2 = new Vector();
  
        double length = Math.sqrt( this.dX*this.dX + this.dY*this.dY );
        if (length != 0) {
          v2.dX = this.dX/length;
          v2.dY = this.dY/length;
        }
  
        return v2;
     }   
  
     // Dot product of two vectors .....
  
     public double dotProduct ( Vector v1 ) {
          return this.dX*v1.dX + this.dY*v1.dY;
     }

  }
