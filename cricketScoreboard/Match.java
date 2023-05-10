package cricketScoreboard;

import java.util.*;

public class Match {
	
	int players;
	int overs;
	Team team1;
	Team team2;
	
	public Match(int numOfPlayers, int numOfOvers)
	{
		players = numOfPlayers;
		overs = numOfOvers;
		team1 = new Team(numOfPlayers);
		team2 = new Team(numOfPlayers);
	}
	
	public void startMatch(Scanner s)
	{
		inning(1, team1, s);
		inning(2, team2, s);
		
		if(team1.score > team2.score)
		{
			System.out.println("Team 1 won the match by "+ (team1.score - team2.score) + " runs");
		}
		else if(team2.score > team1.score)
		{
			System.out.println("Team 2 won the match by "+ (team2.score - team1.score) + " runs");
		}
		else {
			System.out.println("Match got draw between Team 1 and Team 2");
		}
	}
	
	public void inning(int teamNum, Team team, Scanner s)
	{
		
		String battingOrder[] = new String[players];
		
		System.out.println("Batting Order for team " + teamNum+":");
		
		for(int i = 0; i < players; i++)
			battingOrder[i] = s.next();
		
		team.inputBattingOrder(battingOrder);
		
		Player p1 = team.nextPlayer();
		Player p2 = team.nextPlayer();
		
//		System.out.println(p1 + " " + p2);
		
		for(int over = 1; over <= overs; over++)
		{
			System.out.println("Over " + over + ":");
			int ball = 0;
			
			for(ball = 1; ball <= 6; ball++)
			{
				String nextBall = s.next();
				
				if(nextBall.equals("Wd") || nextBall.equals("Nb"))
				{
					team.score++;
					ball--;
					continue;
				}
				
				if(nextBall.equals("W")) {
					team.out++;
					p1.nextBall(0);
					p1 = team.nextPlayer();
					if(p1 == null)
						break;
					
					continue;
				}
				
				try {
					int score = Integer.parseInt(nextBall);
					team.nextBall(score);
//					System.out.println(p1.name + " " + score);
					p1.nextBall(score);
					
					if(score % 2 == 1)
					{
						// Swapping the Players
						Player temp = p1;
						p1 = p2;
						p2 = temp;
					}
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid input W, Wd, Nb or Runs(1-6)");
					ball--;
					continue;
				}
				
//				System.out.println(p1 + " " + p2);
			}
			
			System.out.println();
			
			team.printScoreboard(teamNum, p1, p2);
			
			System.out.println("Total: " + team.score + "/" + team.out);
			
			if(ball == 7)
				System.out.println("Overs: " + over);
			else
				System.out.println("Overs: " + (over - 1) + "." + ball);
			
			System.out.println();
			
			// Swapping the Players
			
			Player temp = p1;
			p1 = p2;
			p2 = temp;
		}
		
//		s.close();
		
	}

}
