package cricketScoreboard;

public class Player {
	
	String name;
	int score;
	int countOfFours;
	int countOfSixes;
	int balls;
	
	public Player(String name)
	{
		this.name = name;
		this.score = 0;
		this.countOfFours = 0;
		this.countOfSixes = 0;
		this.balls = 0;
	}
	
	public void nextBall(int score)
	{
		if(score == 4)
			countOfFours++;
		if(score == 6)
			countOfSixes++;
		
		this.balls++;
		this.score += score;
	}

}
