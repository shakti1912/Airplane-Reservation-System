import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class is responsible for maintaining functionalities of the seat reservation system.
 * 
 * @author ShaktiSinghRathore
 */
public class Reservation {


	private Service service;


	private ArrayList<Passenger[]> Group_People = new ArrayList<Passenger[]>();
	private ArrayList<String> Group_Name = new ArrayList<String>();
	
	/**
     * Default constructor
     * 
     */

	public Reservation()
	{
		service  = new Service();
	}
	
	/**
     * Adding a passenger
     * @param p Passenger Details
     * @return String Seat reserved for passenger
     */

	public String addPassenger(Passenger p)
	{ 	/**
	 * first class
	 */

		if(p.getService().equals("First"))
		{
			String[][] cl = service.getFirstClass();
			/**
			 * window seat
			 */
			if(p.getSeat().equals("W"))
			{
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][0] == null)
					{
						cl[i][0] = p.getName();
						return "seat number is " + i+1 + "A";
					}
				}
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][3] == null)
					{
						cl[i][3] = p.getName();
						return "seat number is " + i+1 + "D";
					}
				}
			}
			/**
			 * Aisle seat or center seat
			 */
			else if(p.getSeat().equals("A") || p.getSeat().equals("C"))
			{
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][1] == null)
					{
						cl[i][1] = p.getName();
						return "seat number is " + i+1 + "B";
					}
				}
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][2] == null)
					{
						cl[i][2] = p.getName();
						return "seat number is " + i+1 + "C";
					}
				}
			}
			else
			{
				return "provide a valid seating preference";
			}
		}
		/**
		 * economy class
		 */

		else if(p.getService().equals("Economy"))
		{
			String[][] cl = service.getEconomyClass();
			/**
			 * window seat
			 */
			if(p.getSeat().equals("W"))
			{
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][0] == null)
					{
						cl[i][0] = p.getName();
						return "seat number is " + i+10 + "A";
					}
				}
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][5] == null)
					{
						cl[i][5] = p.getName();
						return "seat number is " + i+10 + "F";
					}
				}
			}
			/**
			 * Center seat
			 */
			else if(p.getSeat().equals("C"))
			{
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][1] == null)
					{
						cl[i][1] = p.getName();
						return "seat number is " + i+10 + "B";
					}
				}
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][4] == null)
					{
						cl[i][4] = p.getName();
						return "seat number is " + i+10 + "E";
					}
				}
			}
			/**
			 * aisle seat
			 */
			else if(p.getSeat().equals("A"))
			{
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][2] == null)
					{
						cl[i][2] = p.getName();
						return "seat number is " + i+10 + "C";
					}
				}
				for(int i = 0; i < cl[0].length;i++)
				{
					if(cl[i][3] == null)
					{
						cl[i][3] = p.getName();
						return "seat number is " + i+10 + "D";
					}
				}
			}

			else
			{
				return "type valid seating preference";
			}

		}


		return "type valid service preference";



	}
	/**
     * Adding a group reservation
     * @param pass Passenger Details in a group
     * @param gName Group Name
     * @param ser Group service class choice
     * @return String Seat reserved for passenger
     */
	public String addGroup(Passenger[] pass, String gName, String ser)
	{
		String[][] cl = service.getFirstClass();
		String[][] clE = service.getEconomyClass();
		Group_Name.add(gName);
		Group_People.add(pass);
		String result = "";



		int[] vacantSeatF = new int[2];
		int[] vacantSeatE = new int[20];
		int tracker = 0;
		if(ser.equals("First"))
		{
			for(int i = 0; i<cl.length;i++)
			{  
				tracker = 0;
				for(int j=0;j<cl[0].length;j++)
				{
					if(cl[i][j] == null)
					{
						tracker++;
					}

				}
				for(int k = 0; k < vacantSeatF.length;k++)
				{
					vacantSeatF[k] = tracker+1;
				}

			}
			int row = 0;
			int emptySeats = 0;
			for(int i = 0 ; i < vacantSeatF.length; i++)
			{
				emptySeats += vacantSeatF[i];

			}
			for(int z=0;z<vacantSeatF.length;z++)
			{
				if(pass.length <= vacantSeatF[z])
				{
					row = z;
				}
				else if (pass.length > emptySeats)
				{
					return "No empty seats available";
				}
			}
			int tracker1 = 0;
			for(int j=0;j<pass.length;j++)
			{
				if(cl[row][tracker1] == null)
				{
					cl[row][tracker1] = pass[j].getName();
					if(tracker1 == 0)
					{
						result +=  row+1 + "A";
						//return "Reserved seat - row: " + (row+1)+ " column:" + "A");
					}
					if(tracker1 == 1)
					{
						result +=  row+1+"B";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "B");
					}
					if(tracker1 == 2)
					{
						result +=  row+1 + "C";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "C");
					}
					if(tracker1 == 3)
					{	
						result +=  row+1 + "D";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "D");
					}
				}
				if(tracker1<4)
				{
					tracker1++;
				}
			}

		}
		else if (ser.equals("Economy"))
		{
			for(int i = 0; i<clE.length;i++)
			{  
				tracker = 0;
				for(int j=0;j<clE[0].length;j++)
				{
					if(clE[i][j] == null)
					{
						tracker++;
					}

				}
				for(int k = 0; k < vacantSeatE.length;k++)
				{
					vacantSeatE[k] = tracker+1;
				}

			}
			int row = 0;
			int emptySeats = 0;
			for(int i = 0 ; i < vacantSeatF.length; i++)
			{
				emptySeats += vacantSeatF[i];

			}
			for(int z=0;z<vacantSeatE.length;z++)
			{
				if(pass.length <= vacantSeatE[z])
				{
					row = z;
				}
				else if (pass.length > emptySeats)
				{
					return "No empty seats available";
				}
			}
			int tracker1 = 0;
			for(int j=0;j<pass.length;j++)
			{
				if(cl[row][tracker1] == null)
				{
					cl[row][tracker1] = pass[j].getName();
					if(tracker1 == 0)
					{
						result +=  row+1 + "A";
						//return "Reserved seat - row: " + (row+1)+ " column:" + "A");
					}
					if(tracker1 == 1)
					{
						result +=  row+1+"B";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "B");
					}
					if(tracker1 == 2)
					{
						result +=  row+1 + "C";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "C");
					}
					if(tracker1 == 3)
					{	
						result +=  row+1 + "D";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "D");
					}
					if(tracker1 == 4)
					{
						result +=  row+1 + "E";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "C");
					}
					if(tracker1 == 5)
					{	
						result +=  row+1 + "F";
						//System.out.println("Reserved seat - row: " + (row+1)+ " column:" + "D");
					}
				}
				if(tracker1<6)
				{
					tracker1++;
				}
			}
		}
		else
		{
			result =  "provide a valid seating preference";
		}
		return result;



	}
	
	/**
     * Group canceling functionality
     * @param groupName Group Name
     * @return String Seats cancelled 
     */
	public String groupCancellation(String groupName)
	{
		int groupNumber = 0;
		for(int i=0;i<Group_Name.size();i++)
		{
			if(groupName.equals(Group_Name.get(i)))
			{
				groupNumber = i;
			}
		}
		Passenger[] p = Group_People.get(groupNumber);
		ArrayList<String> person = new ArrayList<String>();
		for(int i=0;i<p.length;i++)
		{
			person.add(p[i].getName());
		}
		return cancelReservation(person,"G");
	}
	/**
	 * Cancel a person or group reservation 
	 * @param pass contains the names of the passengers
	 * @param nop number of passenger - it is Individual or Group
	 * @return
	 */

	public String cancelReservation(ArrayList<String> pass, String nop)
	{	
		String[][] cl = service.getFirstClass();
		String[][] clE = service.getEconomyClass();
		String result = "";
		String r = "";
		//boolean found = false;
		//while(!found)

		if(nop.equals("I"))
		{
			for(int i = 0; i < cl.length;i++)
			{
				for(int j = 0; j < cl[0].length;j++)
				{
					if(cl[i][j].equals(pass.get(0)))
					{
						cl[i][j] = null;
						//found = true;
						if(j==0)
							r = "A";
						if(j==1)
							r = "B";
						if(j==2)
							r = "C";
						if(j==3)
							r = "D";
						result += j+1+": "+r; 
						break;
					}
					else
					{
						for(int m = 0; m < clE.length;m++)
						{
							for(int n = 0; n < clE[0].length;n++)
							{
								if(cl[m][n].equals(pass.get(0)))
								{
									cl[m][n] = null;
									//found = true;
									if(n==0)
										r = "A";
									if(n==1)
										r = "B";
									if(n==2)
										r = "C";
									if(n==3)
										r = "D";
									if(n==4)
										r = "E";
									if(n==5)
										r = "F";

									result += n+1+": "+r; 
									break;
								}
							}


						}
					}


				}
			}
		}
		else if(nop.equals("G"))
		{	for(int k = 0; k < pass.size();k++)
		{
			for(int i = 0; i < cl.length;i++)
			{
				for(int j = 0; j < cl[0].length;j++)
				{
					if(cl[i][j].equals(pass.get(k)))
					{
						cl[i][j] = null;
						if(j==0)
							r = "A";
						if(j==1)
							r = "B";
						if(j==2)
							r = "C";
						if(j==3)
							r = "D";
						result += j+1+": "+r; 
						break;
					}
					else
					{
						for(int a = 0; a < pass.size();a++)
						{
							for(int b = 0; b < clE.length;b++)
							{
								for(int c = 0; c < clE[0].length;c++)
								{
									if(clE[b][c].equals(pass.get(a)))
									{
										clE[b][c] = null;
										if(c==0)
											r = "A";
										if(c==1)
											r = "B";
										if(c==2)
											r = "C";
										if(c==3)
											r = "D";
										if(c==4)
											r = "E";
										if(c==5)
											r = "F";

										result += c+1+": "+r; 
										break;
									}
								}

							}
						}

					}
				}

			}
		}
		}
		return result;
	}
/**
 * Prints the list of the available seats that are empty
 * @param ser the service type of the airplane
 * @return a string that has the available seats in the form of string
 */

	public ArrayList<String> printSeatingAvailabilitychart(String ser)
	{	ArrayList<String> print = new ArrayList<String>();
	if(ser.equals("First"))
	{
		String[][] cl = service.getFirstClass();
		String r = "";
		for(int i = 0; i < cl.length;i++)
		{	boolean b = false;
		String seats = "";
		for(int j = 0; j < cl[0].length;j++)
		{
			if(cl[i][j] == null)
			{	
				b = true;
				if(j==0)
					r = "A";
				if(j==1)
					r = "B";
				if(j==2)
					r = "C";
				if(j==3)
					r = "D";
				//print.add(j+1+": "+r);
				seats = seats+r+",";

			}
		}
		if(b)
		{
			print.add(i+1+": "+ seats);
		}
		}
	}
	else if(ser.equals("Economy"))
	{
		String[][] cl = service.getEconomyClass();
		String r = "";
		for(int i = 0; i < cl.length;i++)
		{
			boolean  b =false;
			String seats = "";
			for(int j = 0; j < cl[0].length;j++)
			{
				if(cl[i][j] == null)
				{
					b = true;
					if(j==0)
						r = "A";
					if(j==1)
						r = "B";
					if(j==2)
						r = "C";
					if(j==3)
						r = "D";
					if(j==4)
						r = "E";
					if(j==5)
						r = "F";

					//print.add(j+1+": "+r);
					seats = seats + r +",";

				}
			}
			if(b)
			{
				print.add(i+1+": "+seats);
			}
		}

	}
	return print;
	}	
/**
 * prints the seat number and passenger name
 * @param ser the service type of the plane
 * @return ArryList prints out the manifest list 
 */
	public ArrayList<String> printManifest(String ser)
	{
		ArrayList<String> print = new ArrayList<String>();
		if(ser.equals("First"))
		{
			String[][] cl = service.getFirstClass();
			String r = "";
			for(int i = 0; i < cl.length;i++)
			{
				for(int j = 0; j < cl[0].length;j++)
				{
					if(cl[i][j] != null)
					{
						if(j==0)
							r = "A";
						if(j==1)
							r = "B";
						if(j==2)
							r = "C";
						if(j==3)
							r = "D";
						print.add(i+1+r+": "+cl[i][j]);

					}
				}
			}
		}
		else if(ser.equals("Economy"))
		{
			String[][] cl = service.getEconomyClass();
			String r = "";
			for(int i = 0; i < cl.length;i++)
			{
				for(int j = 0; j < cl[0].length;j++)
				{
					if(cl[i][j] != null)
					{
						if(j==0)
							r = "A";
						if(j==1)
							r = "B";
						if(j==2)
							r = "C";
						if(j==3)
							r = "D";
						if(j==4)
							r = "E";
						if(j==5)
							r = "F";

						print.add(i+1+r+": "+cl[i][j]);

					}
				}
			}

		}
		return print;
	}	

	/**
	 * Quits the program and adds it to the file
	 * @param fileName the name of the file
	 * @param data the data to be stored in the file
	 */
	public void quit(String fileName, ArrayList<String> data) throws FileNotFoundException
	{

		//make printwriter and save the items in the file
		PrintWriter out = new PrintWriter(fileName);
		for(int i = 0; i < data.size();i++)
		{
			out.println(data.get(i));

		}
		out.close();


	}

}					

