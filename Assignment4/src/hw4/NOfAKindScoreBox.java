package hw4;

import java.util.ArrayList;

/**
 * Score box for a given number N of matching dice, where N is specified
 * in the constructor.  A Combination satisfies this category only if it has 
 * (at least) N dice that are the same.  For a Combination that satisfies 
 * this category, the score is the sum of the N dice that have the same value.
 * If there are multiple groups of N with the same value, the group with highest value 
 * is used for the score.  For example, if N is 3 and the combination
 * is (2, 2, 2, 5, 5, 5, 5, 6), the score is 15.
 * 
 * @author Joseph B. Hennings
 */
public class NOfAKindScoreBox extends ParentScoreBox {
	
	/**
	 * private instance of howMany for this child class
	 */
	private int howMany;
	
	/**
	 * Constructs a NOfAKindScoreBox with the given display name
	 * and score.
	 * @param displayName
	 *   name of this score box
	 * @param howMany
	 *   how many dice must match to satisfy this score box
	 */  
	public NOfAKindScoreBox(String displayName, int howMany) {
		super(displayName);
		this.howMany = howMany;
	}
	
	/**
	 * Determines whether the given array contains N of the same
	 * values.
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
		
		// Stores the count of consecutive elements
		ArrayList<Integer> consecutiveCounts  = new ArrayList<Integer>();
		int ofAKind = 1;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) {
				consecutiveCounts.add(ofAKind);
				ofAKind = 1;
			}
			else {
				ofAKind++;
			}
		}
		
		for (int i = 0; i < consecutiveCounts .size(); i++) {
			if (consecutiveCounts .get(i) >= howMany) {
				return true;
			}
		}
		
		return false;
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
	        int score = 0;
	        int lastScore = 0;

	        for (int i = 0; i < arr.length; i++) {
	            int currentCount = 1;

	            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
	                currentCount++;
	                i++;
	            }
	            if (currentCount >= howMany) {
	                score = currentCount * arr[i];
	                lastScore = Math.max(lastScore, score);
	            }
	        }

	        return lastScore;
	    }
	    else {
	        return 0;
	    }
	    
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
			Combination dice = getDice();
			
			int score = 0;
	        int lastScore = 0;
	        int[] arr = dice.getAll();
	        
	        for (int i = 0; i < arr.length; i++) {
	        	int currentCount = 1;
	        	
	            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
	                currentCount++;
	                i++;
	            }
	            if (currentCount >= howMany) {
	                score = currentCount * arr[i];
	                lastScore = Math.max(lastScore, score);
	            }
	        }
	        
	        return lastScore;
			
		}
		else {
			return 0;
		}
		
	}



}
