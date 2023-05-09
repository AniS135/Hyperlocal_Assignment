package SHIELD_Dashboard;

import java.util.*;

public class Mission {
	
	String name;
	String status;
	String missionDetails;
	List<Avenger> list;
	
	public Mission()
	{
		list = new ArrayList<>();
		status = "Assigned";
	}
}
