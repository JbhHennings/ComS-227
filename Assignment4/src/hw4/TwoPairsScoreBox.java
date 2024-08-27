package hw4;

/**
 * Score box that is satisfied by a Combination including
 * at least two dice of one value and two of a different value.
 * The score is the sum of all die values.
 * 
 * @author Joseph B. Hennings
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class TwoPairsScoreBox extends ParentScoreBox {
	
	/**
	 * Constructs a TwoPairsScoreBox with the given display name.
	 * @param displayName
	 *   name for this score box
	 */
	public TwoPairsScoreBox(String displayName) {
		super(displayName);
	}
	
	/**
	 * Determines whether the given array of die contains two pair
	 * of a value.
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
		int twoOfaKind = 0;
		int count = 1;
		int firstValue = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			if (arr[i] == arr[i+1]) {

				if (i == arr.length - 1 || arr[i] != arr[i+1]) {
					break;
				}
				count++;
				i++;
				
				// Recored if two were two or more consecutive elements, but not same the
				// same as the last consecutive three
				if (count >= 2 && arr[i-1] != firstValue) {
					twoOfaKind++;
					firstValue = arr[i-1];
				}
				count = 1;
				
			}
			
		}
		
		return twoOfaKind > 1;
	}
	
}
