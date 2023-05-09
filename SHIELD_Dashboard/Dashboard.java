package SHIELD_Dashboard;

import java.util.*;

public class Dashboard {
	
	Database db;
	
	public Dashboard()
	{
		db = new Database();
		
		String allAvengers[] = {"Iron Man", "Captain America", "Hulk", "Thor", "Black Widow", "Hawkeye"};
		String abilities[] = {"Genius inventor, advanced technology", "Super soldier, expert tactician", 
				"Incredible strength, near-invulnerability", "God of thunder, Asgardian prince",
				"Master spy, martial artist", "Expert marksman, skilled fighter"};
		
		db.addAllAvengersAndAbilities(allAvengers, abilities);
	}
	
	public void checkMissions()
	{
		List<Mission> missions = db.getAllMissions();
		
		if(missions.size() == 0)
		{
			System.out.println("No Mission has been assigned to an Avenger.");
		}
		else {
			System.out.println("Mission Name | Status | Avengers");
			
			for(Mission m : missions)
			{
				System.out.print(m.name + " | " + m.status + " | ");
				
				if(m.list.size() == 1)
					System.out.println(m.list.get(0).name);
				else 
					System.out.println(m.list.get(0).name + ", " + m.list.get(1).name);
			}
		}
	}
	
	public boolean checkAvengerAvailability(String avenger)
	{
		Avenger a = db.getAvenger(avenger);
		
		if(a.missionAssigned < 2)
			return true;
		return false;
	}
	
	public boolean missionAvailable(String missionName)
	{
		Mission m = db.getMission(missionName);
		
		if(m == null)
			return false;
		else {
			return true;
		}
	}
	
	public void addMission(List<String> avengers, String missionName, String missionDetails)
	{
		Mission m = db.getMission(missionName);
		
		if(m != null)
		{
			Avenger a = db.getAvenger(avengers.get(0));
			a.assigningMission(m);
			m.list.add(a);
			db.addMission(missionName, m);
			return;
		}
		
		m = new Mission();
		m.name = missionName;
		m.missionDetails = missionDetails;
		for(String avenger : avengers)
		{
			Avenger a = db.getAvenger(avenger);
			a.assigningMission(m);
			m.list.add(a);
		}
		m.status = "Assigned";
		db.addMission(missionName, m);
	}
	
	public void printMissionDetails(String missionName)
	{
		Mission m = db.getMission(missionName);
		
		System.out.println("Mission Detail : " + m.missionDetails);
		System.out.println("Mission Status : " + m.status);
		System.out.print("Avengers : ");
		
		if(m.list.size() == 1)
			System.out.println(m.list.get(0).name);
		else
			System.out.println(m.list.get(0).name + ", " + m.list.get(1).name);
	}
	
	public void printAvengerDetails(String avengerName)
	{
		Avenger a = db.getAvenger(avengerName);
		
		System.out.println("Person Name : " + a.name);
		System.out.println("Abilities : " + a.ability);
		System.out.println("Mission Assigned : " + a.missionAssigned);
		System.out.println("Mission Completed : " + a.missionCompleted);
	}
	
	public void updateMissionStatus(String missionName, String newStatus)
	{
		Mission m = db.getMission(missionName);
		
		if(m.status.equals(newStatus))
			return;
		if(newStatus.equals("Completed"))
			db.completeAssignedMission(m);
		else
			db.assignCompletedMission(m);
		
		m.status = newStatus;
		
		System.out.print("Email and Sms are sent to ");
		
		if(m.list.size() == 1)
			System.out.println(m.list.get(0).name);
		else
			System.out.println(m.list.get(0).name + ", " + m.list.get(1).name);
		
	}
	
	public void printAvengersList()
	{
		List<Avenger> avengers = db.getAllAvengers();
		
		System.out.println("Avenger Name | Status | Assigned Mission");
		
		for(Avenger avenger : avengers)
		{
			System.out.print(avenger.name + " | " + avenger.status);
			
			ArrayList<Mission> missions = new ArrayList<>(avenger.set);

			for(int i = 0; i < missions.size(); i++)
			{
				if(i == 0)
					System.out.print(" | " + missions.get(i).name);
				else
					System.out.print(", " + missions.get(i).name);
			}
			
			System.out.println();
		}
	}
	
	public void addAvengerToMission(String avengerName, String missionName)
	{
		Avenger a = db.getAvenger(avengerName);
		Mission m = db.getMission(missionName);
		
		if(m.status.equals("Completed"))
		{
			System.out.println("Mission is already completed");
			return;
		}
		
		if(m.list.size() == 2)
		{
			System.out.println("Error : " + m.list.get(0).name + " and " + m.list.get(1).name + " already working on this mission.");
		}
		else
		{
			m.list.add(a);
			a.assigningMission(m);
			
			System.out.println("Avenger has assigned to mission.");
			System.out.println("Email notification sent and/or\r\n"
					+ "SMS notification sent.");
		}
	}
}
