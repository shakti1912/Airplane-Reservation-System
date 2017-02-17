/**
 * This class keeps the details of the passenger.
 * 
 * @author ShaktiSinghRathore
 */
		
public class Passenger 

{
	private String name;
	private String classService;
	private String seat;

/**
 * Constructor creates Passenger object with given parameters
 * @param nm name of the passenger
 * @param ser service class that passenger chose
 * @param st seat preference of the passenger
 */
	public Passenger(String nm, String ser, String st)
	{
		name = nm;
		classService = ser;
		seat = st;
	}

/**
 * this method return the name of the passenger
 * @return returns the name of the passenger
 */
	public String getName()
	{
		return name;
	}
/**
 * This method return the service type selected by the passenger
 * @return returns the service type of the passenger
 */
	public String getService()
	{
		return classService;
	}

	/**
	 * This method gets the seat of the passenger
	 * @return returns the choice of seat type of the passenger
	 */
	public String getSeat()
	{
		return seat;
	}
	/**
	 * This method changes the name of the passenger to the given name
	 * @param n given name to be set as the passenger name
	 */
	public void setName(String n)
	{
		name = n;
	}
	/**
	 * This method changes the service type of the passenger
	 * @param s given service type to be set as the passenger's service type
	 * 
	 */
	public void setService(String s)
	{
		classService = s;
	}
	/**
	 * This method changes the seat type of the passenger
	 * @param st given seat type to be set as the passenger's seat type
	 * 
	 */
	public void setSeat(String st)
	{
		seat = st;
	}

}

