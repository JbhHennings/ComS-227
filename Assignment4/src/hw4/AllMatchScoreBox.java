package hw4;

/**
 * Score box for all dice the same.  A Combination
 * with N dice satisfies this category only if all N
 * values are the same.  For a Combination that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 * 
 * @author Joseph B. Hennings
 */
public class AllMatchScoreBox extends ParentScoreBox {
	/**
	 * Private instance of score for this child class
	 */
	private int score;
	
	/**
	 * Constructs a AllMatchScoreBox with the given display name
	 * and score.
	 * @param displayName
	 *   name of this score box
	 * @param points
	 *   points awarded for a combination that satisfies this score box
	 */  
	public AllMatchScoreBox(String displayName, int points) {
		super(displayName);
		score = points;
	}
	
	/**
	 * Determines whether the values given array of die are all the same.
	 * This method does not modify the state
	 * of this score box.
	 * @param arr
	 *   array to check, in increasing order
	 * @return
	 *   true if the given values can be used to satisfy the 
	 *   score box, false otherwise
	 */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		boolean sameValue = false;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) {
				sameValue = true;
				break;
			}
		}
		if (sameValue == true) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returns the score for this score box, or zero if the 
	 * category is not <em>filled</em>.
	 * @return
	 *   score for the score box or zero if not filled
	 */
	@Override
	public int getScore() {
		if (getDice() != null && isFilled()) {
			return score;
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
	@Override
	public int getPotentialScore(int[] arr) {
		if (isSatisfiedBy(arr)) {
			return score;
		}
		else {
			return 0;
		}
	}

}
