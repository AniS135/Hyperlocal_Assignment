package cricketScoreboard;

import java.util.*;

public class Team {
	
	int numOfPlayers;
	Player playerOrder[];
	int nextGonnaBePlayer;
	int score;
	int out;
	
	public Team(int size)
	{
		numOfPlayers = size;
		playerOrder = new Player[size];
		nextGonnaBePlayer = 0;
		score = 0;
		out = 0;
	}
	
	public void inputBattingOrder(String order[])
	{
		for(int i = 0; i < numOfPlayers; i++)
			playerOrder[i] = new Player(order[i]);
	}
	
	public Player nextPlayer()
	{
		if(nextGonnaBePlayer >= numOfPlayers)
			return null;
		
		return playerOrder[nextGonnaBePlayer++];
	}
	
	public void nextBall(int score)
	{
		this.score += score;
	}
	
	public void printScoreboard(int teamNum, Player p1, Player p2)
	{
		System.out.println("Scoreboard for team "+ teamNum + " :");
		
		Formatter fmt = new Formatter();  
		fmt.format("%14s %14s %14s %14s %14s\n", "Player Name", "Score", "4s", "6s", "Balls");
		
		for(int i = 0; i < numOfPlayers; i++)
		{
			if(playerOrder[i] == p1 || playerOrder[i] == p2)
			{
				fmt.format("%14s %14s %14s %14s %14s\n", playerOrder[i].name+"*", playerOrder[i].score, 
						playerOrder[i].countOfFours, playerOrder[i].countOfSixes, playerOrder[i].balls);  
			}
			else {
				fmt.format("%14s %14s %14s %14s %14s\n", playerOrder[i].name, playerOrder[i].score, 
						playerOrder[i].countOfFours, playerOrder[i].countOfSixes, playerOrder[i].balls);
			}
		}
		
		System.out.print(fmt);
	}

}
