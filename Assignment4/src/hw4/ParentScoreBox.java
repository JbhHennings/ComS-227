package hw4;
import api.ScoreBox;

/**
 * The abstract class that extends to all of the other
 * score box classes and includes all of their common
 * characteristics. The only score box method not in
 * this class is 'isSatisfiedBy', since almost every
 * child class will use it differently. All methods 
 * in this abstract class are shared.
 * 
 * @author Joseph B. Hennings
 */
public abstract class ParentScoreBox implements ScoreBox {
	/**
	 * Private instance of 'Combination' for combination instatiation
	 */
	private Combination dice;
	/**
	 * Private display name for this score box
	 */
	private String displayName;
	
	/**
	 * Constructs a ParentScoreBox with given display name
	 * @param displayName
	 * 	name for this score box
	 */
	public ParentScoreBox(String displayName) {
		this.displayName = displayName;
	}
	
	/**
	 * Permanently sets the combination being used to satisfy
	 * this category.  The score is set to the value of
	 * <code>getPotentialScore</code> for this combination's 
	 * completed dice.
	 * @param dice
	 *   combination to be used to satisfy this category
	 * @throws IllegalStateException
	 *   if the given combination is not complete (according
	 *   to the <code>isComplete()</code> method of Combination
	 */
	public void fill(Combination dice) {
		if (!dice.isComplete()) {
			IllegalStateException e = new IllegalStateException();
			throw e;
		}
		else {
			int[] arr = dice.getCompletedDice();
			
			if (isSatisfiedBy(arr)) {
				this.dice = dice;
			}
		}
	}
	
	/**
	 * Determines whether this score box is filled.
	 * @return
	 *   true if this score box has a fixed dice group and score, 
	 *   false otherwise
	 */
	public boolean isFilled() {
		// If 'dice' has not been set
		if (dice != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the combination used to satisfy this category, or null if
	 * not <em>filled</em>.
	 * @return
	 *   combination satisfying this category, or null if not done
	 */
	public Combination getDice() {
		
		int[] arr;
		if (dice != null) {
			arr = dice.getAll();
		}
		else  {
			arr = null;
		}
			
		if (arr != null && isSatisfiedBy(arr) == true) {
			return dice;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Returns the name for this category.
	 * @return
	 *   name for this category
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * Returns the score for this score box, or zero if the 
	 * category is not <em>filled</em>.
	 * @return
	 *   score for the score box or zero if not filled
	 */
	public int getScore() {
		int sum = 0;
		
		if (dice != null && isFilled()) {
			int[] arr = dice.getAll();
			
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			
			return sum;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Returns the potential score that would result from 
	 * using the given array of die values to satisfy this score box.
	 * Always returns zero if the <code>isSatisfiedBy()</code> 
	 * method returns false for the given array.
	 * This method does not modify the state of this score box.
	 * @param arr
	 *   array to check, in increasing order
	 * @return
	 *   potential score for the given die values
	 */
	public int getPotentialScore(int[] arr) {
		if (isSatisfiedBy(arr)) {
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			return sum;
		}
		else {
			return 0;
		}
	}
	
}
