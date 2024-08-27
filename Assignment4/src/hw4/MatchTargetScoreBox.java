package hw4;

/**
 * Score box that is based on counting dice that match
 * a particular target value (as specified in the constructor).
 * This category is satisfied by any Combination.  The score
 * is the sum of the dice that match the target.
 * 
 * @author Joseph B. Hennings
 */
public class MatchTargetScoreBox extends ParentScoreBox {

	/**
	 * Instance variable of the value to be matched
	 */
	private int whichValue;
	
	/**
	 * Constructs a MatchTargetScoreBox with the given display name and 
	 * target value.
	 * @param displayName
	 *   name for this score box
	 * @param whichValue
	 *   target value that must be matched for the dice to count toward the
	 *   score
	 */
	public MatchTargetScoreBox(String displayName, int whichValue) {
		super(displayName);
		this.whichValue = whichValue;
	}
	
	/**
	 * Returns the score for this score box, or zero if the 
	 * category is not <em>filled</em>.
	 * @return
	 *   score for the score box or zero if not filled
	 */
	@Override
	public int getScore() {
		Combination dice = getDice();
		
		if (getDice() != null && isFilled()) {
			int[] arr = dice.getAll();
			int numMatches = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == whichValue) {
					numMatches++;
				}
			}
			return numMatches * whichValue;
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
		int numMatches = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == whichValue) {
				numMatches++;
			}
		}
		
		return numMatches * whichValue;
	}
	
	/**
	 * Determines whether the given array of die values satisfies
	 * this score box.  This method does not modify the state
	 * of this score box.
	 * @param arr
	 *   array to check, in increasing order
	 * @return
	 *   true if the given values can be used to satisfy the 
	 *   score box, false otherwise
	 */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		return true;
	}

}
