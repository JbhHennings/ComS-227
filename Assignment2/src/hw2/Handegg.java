package hw2;

/** 
 * This class encapsulates the logic and state for a highly simplified
 * game of American football.  
 * 
 * @author Joseph Hennings
 */
public class Handegg {
	
	/**
   	 * Number of points awarded for a touchdown.
   	 */ 
	public static final int TOUCHDOWN_POINTS = 6;
  
	/**
   	 * Number of points awarded for a successful extra point attempt
   	 * after a touchdown.
   	 */
	public static final int EXTRA_POINTS = 1;
  
	/**
   	 * Number of points awarded for a field goal.
   	 */
	public static final int FIELD_GOAL_POINTS = 3;
  
	/**
   	 * Total length of the field from goal line to goal line, in yards.
   	 */
	public static final int FIELD_LENGTH = 100;
  
	/**
   	 * Initial position of the offensive team after a touchdown and extra point attempt.
   	 */
	public static final int STARTING_POSITION = 30;
  
	/**
   	 * Yards required to get a first down.
   	 */ 
	public static final int YARDS_FOR_FIRST_DOWN = 10;
	
	private int points;
	private int team;
	private int ball;
	private int down;
	private int thisDown;
	private int nextDown;
	private int teamZeroPoints;
	private int teamOnePoints;
	private int yardsToFirstDown;
  
	/**
	 * Constructor
	 */
	public Handegg() {
	  team = 0;
	  ball = STARTING_POSITION;
	  down = 1;
	  thisDown = STARTING_POSITION;
	  nextDown = STARTING_POSITION + 10;
	}
  
	/**
	 * @param success
	 */
	public void extraPoint(boolean success) {
		
		if (team == 0 && success == true) {
			teamZeroPoints += EXTRA_POINTS;
			team = 1 - team;
		}
		else if (team == 1 && success == true) {
			teamOnePoints += EXTRA_POINTS;
			team = 1 - team;
		}
		
	}
	
	/**
	 * @param success
	 */
	public void fieldGoal(boolean success) {
		
		if (team == 0 && success == true) {
			teamZeroPoints += FIELD_GOAL_POINTS;
			team = 1 - team;
		}
		else if (team == 1 && success == true) {
			teamOnePoints += FIELD_GOAL_POINTS;
			team = 1 - team;
		}
		else {
			team = 1 - team;
		}
		
	}
	
	/**
	 * @return
	 */
	public int getLocation() {
		return ball;
	}
	
	/**
	 * @param whichTeam
	 * @return
	 */
	public int getScore(int whichTeam) {
		
		if (whichTeam == 0) {
			return teamZeroPoints;
		}
		else if (whichTeam == 1) {
			return teamOnePoints;
		}
		else {
			return 0;
		}
		
	}
	
	/**
	 * @return
	 */
	public int getYardsToFirstDown() {
		//TODO
		return nextDown - thisDown;
	}
	
	/**
	 * @param yards
	 * @param intercepted
	 */
	public void pass(int yards, boolean intercepted) {
		//TODO
	}
	
	/**
	 * @param yards
	 */
	public void punt(int yards) {
		ball = yards - ball;
		team = 1 - team;
	}
	
	/**
	 * @param yards
	 */
	public void run(int yards) {
		ball += yards;
		down ++;
		thisDown += yards;
		
		if (ball >= FIELD_LENGTH && team == 0) {
			teamZeroPoints += 6;
		}
		else if (ball >= FIELD_LENGTH && team == 1) {
			teamZeroPoints += 6;
		}
	}
	
	/**
	 * @return
	 */
	public int whichDown() {
		return down;
	}
	
	/**
	 * @return team
	 */
	public  int whoIsOffense() {
		return team;
	}
}
