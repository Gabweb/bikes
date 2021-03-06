/*
 * Interface for all Coordinate classes
 */
package org.wahlzeit.model;

public interface Coordinate {

	/*
	 * @methodtype query
	 */
	public double getDistance(Coordinate in);
	
	/*
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate in);
	
	/*
	 * @methodtype get
	 */
	public double getX();
	
	/*
	 * @methodtype get
	 */
	public double getY();
	
	/*
	 * @methodtype get
	 */
	public double getZ();
}
