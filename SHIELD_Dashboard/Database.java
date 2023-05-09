package SHIELD_Dashboard;

import java.util.*;

public class Database {
	
	HashMap<String, Avenger> Avengers;
	HashMap<String, Mission> Missions;
	
	public Database()
	{
		Avengers = new HashMap<>();
		Missions = new HashMap<>();
	}
	
	public void addAllAvengersAndAbilities(String allAvengers[], String abilities[])
	{
		for(int i = 0; i < allAvengers.length; i++)
			Avengers.put(allAvengers[i], new Avenger(allAvengers[i], abilities[i]));
	}
	
	public List<Mission> getAllMissions()
	{
		return new ArrayList<Mission>(Missions.values());
	}
	
	public List<Avenger> getAllAvengers()
	{
		return new ArrayList<Avenger>(Avengers.values());
	}
	
	public Avenger getAvenger(String avenger)
	{
		return Avengers.get(avenger);
	}
	
	public Mission getMission(String missionName)
	{
		if(!Missions.containsKey(missionName))
			return null;
		
		return Missions.get(missionName);
	}
	
	public void addMission(String missionName, Mission m)
	{
		Missions.put(missionName, m);
	}
	
	public void completeAssignedMission(Mission m)
	{
		for(Avenger avg : m.list)
		{
			avg.completeAssignedMission();
		}
	}
	
	public void assignCompletedMission(Mission m)
	{
		for(Avenger avg : m.list)
		{
			avg.assignCompletedMission();
		}
			
	}
	
	
}
