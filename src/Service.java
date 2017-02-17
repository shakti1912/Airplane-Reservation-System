/**
 * This is the service class of the reservation system 
 * @author ShaktiSinghRathore
 *
 */
public class Service {

	private String service;
	private String[][] first;
	private String[][] economy;

/**
 * Default Constructor
 */
	public Service()
	{
		//service = s;
		first = new String[4][2];
		economy = new String[6][20];
	}
	
	/**
     * Get the name of the passenger
     * @return String Servive Class: First or Economy
     */
	public String getService()
	{
		return service;
	}
	
	/**
     * Get the name of the passenger
     * @return String[][] First Class Seating Chart
     */
	public String[][] getFirstClass()
	{

		return first;

	}
	
	/**
     * Get the name of the passenger
     * @return String[][] Economy Class Seating Chart
     */
	public String[][] getEconomyClass()
	{

		return economy;

	}
}

