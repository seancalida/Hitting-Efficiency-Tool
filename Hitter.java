package offenseStatTrack;

/**
 * Player class with information required 
 * for hitting percentage
 * 
 * @author Sean Calida
 * @version 1/27/18
 */
public class Hitter {

	private String hitterName;
	private int kills;
	private int errors;
	private int attempts;
	
	/*
	 * Constructor for volleyball player
	 */
	public Hitter(String name) {
		hitterName = name;
		kills = 0;
		errors = 0;
		attempts = 0;
	}
	
	/*
	 * @return kills
	 */
	public int getKills() {
		return kills;
	}
	
	/*
	 * @return errors
	 */
	public int getErrors() {
		return errors;
	}
	
	/*
	 * @return attempts
	 */
	public int getAttempts() {
		return attempts;
	}
	
	/*
	 * @return hitter name
	 */
	public String getHitterName() {
		return hitterName;
	}
	
	/*
	 * adds 1 to kill total
	 */
	public void addKill() {
		kills++;
	}
	
	/*
	 * adds 1 to error total
	 */
	public void addError() {
		errors++;
	}
	
	/*
	 * adds 1 to attempt total
	 */
	public void addAttempt() {
		attempts++;
	}
	
	/*
	 * Calculates the hitting percentage number
	 * @return hitting percentage times a thousand
	 */
	public int getHP() {
		double hp = (float)(kills - errors) / (float)attempts;
		int result = (int) Math.round(hp * 1000);
		return result;
	}
	
	/*
	 * toString for this player class
	 * @return playerName has # kills, # errors, and # attempts.
	 */
	public String toString() {
		return hitterName + " has " + kills + " kills, " + errors + " errors, " + attempts + " attempts.";
	}
}
