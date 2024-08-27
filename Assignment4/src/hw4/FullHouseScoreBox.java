package hw4;

/**
 * Score box that is satisfied by a Combination including
 * at least three dice of one value and two of a different value.
 * The score is the sum of all die values.
 * 
 * @author Joseph B. Hennings
 */
public class FullHouseScoreBox extends ParentScoreBox {
	/**
	 * Constructs a FullHouseScoreBox with the given display name.
	 * @param displayName
	 *   name for this score box
	 */
	public FullHouseScoreBox(String displayName) {
		super(displayName);
	}
	
	/**
	 * Determines whether the given array of die contains three dice
	 * of one value and two of another.
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
		int threeOfaKind = 0;
		int twoOfaKind = 0;
		int count = 1;
		int firstValue = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			// Check is current element is equal to next element
			if (arr[i] == arr[i+1]) {
				
				// Begins a loop that breaks if the current element is not equal to the next one
				for (int j = 0; j < 2; j++) {
					if (i == arr.length - 1 || arr[i] != arr[i+1]) {
						break;
					}
					count++;
					i++;
				}
				
				// Recored if there were three or more consecutive elements, but not same the
				// same as the last consecutive three
				if (count >= 3 && arr[i-1] != firstValue) {
					threeOfaKind++;
					firstValue = arr[i-1];
				}
				else if (count >= 2 && arr[i-1] != firstValue) {
					twoOfaKind++;
					firstValue = arr[i-1];
				}
				count = 1;
				
			}
			
		}
		
		return (threeOfaKind > 0 && twoOfaKind > 0) || threeOfaKind > 1;
	}
}
