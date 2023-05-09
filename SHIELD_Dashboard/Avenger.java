package SHIELD_Dashboard;

import java.util.*;

public class Avenger {
	String name;
	String ability;
	int missionAssigned;
	int missionCompleted;
	String status;
	HashSet<Mission> set;
	
	
	public Avenger(String name, String ability)
	{
		this.name = name;
		this.ability = ability;
		missionAssigned = 0;
		missionCompleted = 0;
		status = "Available";
		set = new HashSet<Mission>();
	}
	
	public void completeAssignedMission()
	{
		this.missionAssigned--;
		this.missionCompleted++;
		
		if(this.missionAssigned == 0)
			this.status = "Available";
		else
			this.status = "On Mission";
	}
	
	public void assignCompletedMission()
	{
		this.missionAssigned++;
		this.missionCompleted--;
		
		if(this.missionAssigned == 0)
			this.status = "Available";
		else
			this.status = "On Mission";
	}
	
	public void assigningMission(Mission m)
	{
		this.missionAssigned++;
		this.set.add(m);
		
		if(this.missionAssigned == 0)
			this.status = "Available";
		else
			this.status = "On Mission";
	}
	
	
	
}
