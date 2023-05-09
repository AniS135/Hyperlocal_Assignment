package cricketScoreboard;

import java.util.*;

public class Scoreboard_Manager {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("No. of players for each team: ");
		int n = s.nextInt();
		
		System.out.println("No. of overs: ");
		int o = s.nextInt();
		
		Match match = new Match(n, o);
		
		match.startMatch(s);
		
		s.close();
	}

}
