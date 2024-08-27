package hw4;

/**
 * Score box that is satisfied by any Combination.
 * The score is the sum of all die values.
 * 
 * @author Joseph B. Hennings
 */
public class ChanceScoreBox extends ParentScoreBox {
	/**
	 * Constructs a ChanceScoreBox with the given display name.
	 * @param displayName
	 *   name for this score box
	 */
	public ChanceScoreBox (String displayName) {
		super(displayName);
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
