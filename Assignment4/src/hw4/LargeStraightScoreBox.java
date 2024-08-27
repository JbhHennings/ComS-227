package hw4;

/**
 * Score box for a large straight.  A Combination
 * with N dice satisfies this category only if it consists of
 * N distinct consecutive values.  For a dice group that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 * 
 * @author Joseph B. Hennings
 */
public class LargeStraightScoreBox extends ParentScoreBox {
	
	/**
	 * Private instance of score for this child class
	 */
	private int score;
	
	/**
	 * Constructs a LargeStraightScoreBox with the given display name
	 * and score.
	 * @param displayName
	 *   name of this score box
	 * @param points
	 *   points awarded for a dice group that satisfies this score box
	 */  
	public LargeStraightScoreBox(String displayName, int points) {
		super(displayName);
		score = points;
	}
	
	/**
	 * Determines whether the given array of die contains N distinct 
	 * consecutive values.
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
	    boolean b = true;
	    int count = 1;

	    for (int i = 0; i < arr.length - 1; i++) {
	    	
	        if (arr[i] != arr[i + 1]) {
	            if (count < 2) {
	                b = false;
	            }
	            count = 1;
	        }
	        else {
	            count++;
	        }
	        
	    }

	    // Check the last element
	    if (count < 2) {
	        b = false;
	    }

	    return b;
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
