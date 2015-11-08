package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;

	/*
	 * @methodtype constructor
	 */
	public SphericCoordinate(double lat, double lon) {
		setLatitude(lat);
		setLongitude(lon);
	}

	/*
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/*
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/*
	 * @methodtype set
	 */
	public void setLatitude(double lat) throws IllegalArgumentException {
		if (lat > 90 || lat < -90 || Double.isNaN(lat))
			throw new IllegalArgumentException("bad latitude");
		latitude = lat;
	}

	/*
	 * @methodtype set
	 */
	public void setLongitude(double lon) throws IllegalArgumentException {
		if (lon > 180 || lon < -180 || Double.isNaN(lon))
			throw new IllegalArgumentException("bad longitude");
		longitude = lon;
	}

	/*
	 * @methodtype query
	 */
	@Override
	public double getDistance(Coordinate in) {
		assertValidCoordinate(in);
		
		SphericCoordinate tmp = asSphericCoordinate(in);
		//TODO
		return Math.sqrt(Math.pow(getLatitudinalDistance(in), 2) + Math.pow(getLongitudinalDistance(in), 2));
	}
	
	/*
	 * @methodtype query
	 */
	public double getLatitudinalDistance(Coordinate in) {	
		assertValidCoordinate(in);
		
		SphericCoordinate tmp = asSphericCoordinate(in);
		
		return Math.abs(latitude - tmp.getLatitude());
	}

	/*
	 * @methodtype query
	 */
	public double getLongitudinalDistance(Coordinate in) {
		assertValidCoordinate(in);
		
		SphericCoordinate tmp = asSphericCoordinate(in);
		
		return Math.abs(longitude - tmp.getLongitude());
	}

	/*
	 * @methodtype comparison
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * @methodtype boolean query
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SphericCoordinate))
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

}
