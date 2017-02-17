/**
 * 
 * This is the main method of the reservation system program
 * @author ShaktiSinghRathore
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReservationSystem 
{

	/**
	 * This is the main method of the reservation system program
	 * @param args this is the array read from the command line
	 * @throws FileNotFoundException throw exception when file cannot found
	 */
	public static void main(String[] args) throws FileNotFoundException

	{	ArrayList<String> names = new ArrayList<String>();
	Reservation reservation = new Reservation();
	ArrayList<String> DATA = new ArrayList<String>();
	
		File file = new File(args[0]);

		if(file.exists()== true)
		{	
		
			Scanner fromFile = new Scanner(file);
			String request = fromFile.nextLine();
			while(fromFile.hasNext())
			{
			if(request.equals("P"))
			{	
				//System.out.println("Type the passenger name");
				String name = fromFile.nextLine();
				//System.out.println("Type the service class name");
				String serclass = fromFile.nextLine();
				//System.out.println("Type the seat preference");
				String seatPreference = fromFile.nextLine();
				Passenger p = new Passenger(name, serclass, seatPreference);
				String seatNumber = reservation.addPassenger(p);

				if(!seatNumber.equals("provide a valid seating preference"))
				{
					//System.out.println(reservation.addPassenger(p));
					DATA.add(seatNumber+", I, " + name);

				}

			}
			else if(request.equals("G"))
			{
				//System.out.println("Type the group name");
				String groupName = fromFile.nextLine();
				//System.out.println("Type the names of the passengers");
				String namesList = fromFile.nextLine();
				String[] list = namesList.split(",");
				//System.out.println("Type the service class name");
				String serclass = fromFile.nextLine();
				Passenger[] p = new Passenger[list.length];
				for(int i = 0; i < p.length;i++)
				{

					p[i].setName(list[i]);
					p[i].setService(serclass);
					p[i].setSeat("No Worries");
				}

				String seatNumber = reservation.addGroup(p, groupName, serclass);
				//System.out.println(seatNumber);		

				if(!seatNumber.equals("provide a valid seating preference"))
				{
					//System.out.println(reservation.addPassenger(p));
					String[] grouplist = seatNumber.split(",");
					for(int i= 0; i<grouplist.length;i++)
					{
						DATA.add(grouplist[i]+", G, " + list[i]);
					}
				}

			}

			else if (request.equals("C"))
			{
				System.out.println("Cancel [I]ndividual or [G]roup?");

				String numberOfPassengers = fromFile.nextLine();
				if(numberOfPassengers.equals("I"))
				{
					//System.out.println("Type the name of the passenger");
					String name = fromFile.nextLine();

					names.add(name);
					String cancel = reservation.cancelReservation(names, numberOfPassengers);
					cancel = cancel + ", I, " + names.get(0);
					DATA.remove(cancel);

				}
				else if (numberOfPassengers.equals("G"))
				{
					//System.out.println("Type the name of the group");
					String groupName = fromFile.nextLine();
					String cancel = reservation.groupCancellation(groupName);
					cancel = cancel + ", G "+ groupName + ", ";
					for(int i = 0; i < names.size();i++)
					{
						cancel = cancel + names.get(i);
					}
					DATA.remove(cancel);

				}
				else
				{
					System.out.println("Type a valid choice");
				}
			}
			else if(request.equals("A"))
			{
				//ystem.out.println("Enter the type of service class");
				String type = fromFile.nextLine();
				reservation.printSeatingAvailabilitychart(type);

			}
			else if(request.equals("M"))
			{
				//System.out.println("Enter the type of service class");
				String type = fromFile.nextLine();
				reservation.printManifest(type);
			}
			else if(request.equals("Q"))
			{
				reservation.quit(args[0], DATA);
			}

			else
			{
				System.out.println("Enter a valid choice please");
				
			}
			//fromFile.close();
		}
		}
	

	else
	{

		//PrintWriter out = new PrintWriter(f);
		Scanner in = new Scanner(System.in);
		String request = "";

		do{
			System.out.println("Welcome to ReservationSystem");
			System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations, " +
					"Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");

			request = in.nextLine();
			if(request.equals("P"))
			{	

				System.out.println("Type the passenger name");
				String name = in.next();
				System.out.println("Type the service class name");
				String serclass = in.next();
				System.out.println("Type the seat preference");
				String seatPreference = in.next();
				Passenger p = new Passenger(name, serclass, seatPreference);
				String seatNumber = reservation.addPassenger(p);
				if(!seatNumber.equals("provide a valid seating preference"))
				{
					DATA.add(seatNumber+", I, "+ name);
				}


			}
			else if(request.equals("G"))
			{
				System.out.println("Type the group name");
				String groupName = in.next();
				System.out.println("Type the names of the passengers");
				String names1 = in.next();
				String[] list = names1.split(",");
				System.out.println("Type the service class name");
				String serclass = in.next();
				Passenger[] p = new Passenger[list.length];
				for(int i = 0; i < p.length;i++)
				{

					p[i].setName(list[i]);
					p[i].setService(serclass);
					p[i].setSeat("No Worries");
				}

				String seatNumber = reservation.addGroup(p, groupName, serclass);
				if(!seatNumber.equals("provide a valid seating preference"))
				{
					//System.out.println(reservation.addPassenger(p));
					//String[] grouplist = seatNumber.split(",");
					for(int i= 0; i<p.length;i++)
					{
						DATA.add(p[i]+", G, " + list[i]);
					}
				}	
			}
			else if (request.equals("C"))
			{
				System.out.println("Cancel [I]ndividual or [G]roup?");

				String numberOfPassengers = in.next();
				if(numberOfPassengers.equals("I"))
				{
					System.out.println("Type the name of the passenger");
					String name = in.next();
					ArrayList<String> names1 = new ArrayList<String>();
					names.add(name);
					String cancel = reservation.cancelReservation(names1, numberOfPassengers);
					cancel = cancel + ", I, "+names1.get(0);
					DATA.remove(cancel);
				}
				else if (numberOfPassengers.equals("G"))
				{
					System.out.println("Type the name of the group");
					String groupName = in.next();
					String cancel = reservation.groupCancellation(groupName);
					cancel = cancel + ", G "+ groupName + ", ";
					for(int i = 0; i < names.size();i++)
					{
						cancel = cancel + names.get(i);
					}
					DATA.remove(cancel);

				}
				else
				{
					System.out.println("Type a valid choice");
				}
			}
			else if(request.equals("A"))
			{
				System.out.println("Enter the type of service class");
				String type = in.next();
				reservation.printSeatingAvailabilitychart(type);

			}
			else if(request.equals("M"))
			{
				System.out.println("Enter the type of service class");
				String type = in.next();
				reservation.printManifest(type);
			}
			else
			{
				reservation.quit(args[0], DATA);
			}

		}
		while(in.hasNextLine());

	}

	//PrintWriter writer = new PrintWriter(args[0]);
	}

}



