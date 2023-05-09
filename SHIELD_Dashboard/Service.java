package SHIELD_Dashboard;

import java.util.*;

public class Service {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("=======------S.H.I.E.L.D ------=========");
		System.out.println("Welcome to SHIELD Dashboard");
		
		checkAuthentication();
		
		System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)\r\n"
				+ "1. Check the missions\r\n"
				+ "2. Assign mission to Avengers\r\n"
				+ "3. Check mission’s details\r\n"
				+ "4. Check Avenger’s details\r\n"
				+ "5. Update Mission’s status\r\n"
				+ "6. List Avengers\r\n"
				+ "7. Assign avenger to mission\r\n"
				+ "8. Exit from Dashboard.");
		
		Dashboard dashboard = new Dashboard();
		HashSet<String> Avengers = new HashSet<>();
		Avengers.add("Iron Man");
		Avengers.add("Captain America");
		Avengers.add("Hulk");
		Avengers.add("Thor");
		Avengers.add("Black Widow");
		Avengers.add("Hawkeye");
		
		while(true)
		{
			System.out.println("Enter the option : ");
			
			int option = s.nextInt();
			s.nextLine();
			
			if(option == 1) {
				dashboard.checkMissions();
				System.out.println("=======------------=========");
			}
			else if(option == 2)
			{
				System.out.println("Enter the number of avengers to whom you want to Assign the mission(1 or 2): ");
				int num = s.nextInt();
				s.nextLine();
				while(num != 1 && num != 2)
				{
					System.out.println("Please enter a valid number : ");
					num = s.nextInt();
					s.nextLine();
				}
				
				List<String> avengers = new ArrayList<>();
				int i = 0;
				boolean available = true;
				while(i < 2)
				{
					System.out.println("Enter "+(i + 1)+" Avenger : ");
					String avgName = s.nextLine();
					if(!Avengers.contains(avgName))
					{
						System.out.println("Please enter a valid Avenger Name from list - {Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye}");
						continue;
					}
					
					if(!dashboard.checkAvengerAvailability(avgName))
					{
						System.out.println("Sorry, "+ avgName +" has already been working on two missions.");
						available = false;
						break;
					}
					
					avengers.add(avgName);
					i++;
				}
				if(!available) continue;
				
				System.out.println("Enter Mission Name: ");
				String missionName = s.nextLine();
				
				if(dashboard.missionAvailable(missionName))
				{
					System.out.println("Mission is already there in missions list");
					continue;
				}
				 
				System.out.println("Enter Mission Details:");
				String missionDetails = s.nextLine();
				
				dashboard.addMission(avengers, missionName, missionDetails);
				
				System.out.println("Mission has been assigned.\r\n"
						+ "Email notification sent and/or\r\n"
						+ "SMS notification sent.\r\n"
						+ "");
				
				System.out.println("=======------------=========");
			}
			else if(option == 3)
			{
				System.out.println("Enter a mission name : ");
				
				String missionName = s.nextLine();;
				
				if(!dashboard.missionAvailable(missionName)) {
					System.out.println("No mission is assigned with name :" + missionName);
					continue;
				}
				
				dashboard.printMissionDetails(missionName);
				System.out.println("=======------------=========");
			}
			else if(option == 4)
			{
				System.out.println("Enter Avenger Name : ");
				String avengerName = s.nextLine();
				if(!Avengers.contains(avengerName))
				{
					System.out.println("Please enter a valid Avenger Name from list - {Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye}");
					continue;
				}
				
				dashboard.printAvengerDetails(avengerName);
				System.out.println("=======------------=========");
			}
			else if(option == 5)
			{
				System.out.println("Enter Mission Name : ");
				String missionName = s.nextLine();
				
				if(!dashboard.missionAvailable(missionName))
				{
					System.out.println("No mission is assigned with name :" + missionName);
					continue;
				}
				
				System.out.println("Enter New Status : ");
				String newStatus = s.nextLine();
				
				dashboard.updateMissionStatus(missionName, newStatus);
				System.out.println("=======------------=========");
			}
			else if(option == 6)
			{
				dashboard.printAvengersList();
				System.out.println("=======------------=========");
			}
			else if(option == 7)
			{
				System.out.println("Enter Avenger : ");
				String name = s.nextLine();
				
				if(!Avengers.contains(name))
				{
					System.out.println("Please enter a valid Avenger Name from list - {Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye}");
					continue;
				}
				
				if(!dashboard.checkAvengerAvailability(name))
				{
					System.out.println("Sorry, "+ name +" has already been working on two missions.");
					continue;
				}
				
				System.out.println("Enter Mission Name : ");
				String missionName = s.nextLine();
				
				if(!dashboard.missionAvailable(missionName))
				{
					System.out.println("No mission is assigned with name :" + missionName);
					continue;
				}
				
				dashboard.addAvengerToMission(name, missionName);
				System.out.println("=======------------=========");
			}
			else if(option == 8)
			{
				System.out.println("Thank you for visiting dashboard");
				break;
			}
			else {
				System.out.println("Please enter a valid option");
				System.out.println("=======------------=========");
			}
		}
		
	}
	
	private static void checkAuthentication()
	{
		System.out.println("Login as ->");
		System.out.println("1. Captain Fury");
		
		while(true)
		{
			System.out.println("Enter the option : ");
			int n = s.nextInt();
			
			if(n == 1)
				break;
			else
				System.out.println("Please enter a valid option");
		}
	}

}
