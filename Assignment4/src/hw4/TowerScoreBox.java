package hw4;

/**
 * Score box that is satisfied by a Combination including at least
 * four dice of one value and two of a different value
 * The score is the sum of all die values.
 * 
 * @author Joseph B. Hennings
 */
public class TowerScoreBox extends ParentScoreBox {
	
	/**
	 * Constructs a TowerScoreBox with the given display name.
	 * @param displayName
	 *   name for this score box
	 */
	public TowerScoreBox(String displayName) {
		super(displayName);
	}
	
	/**
	 * Determines whether the given array of die contains
	 * four of one value and two of a different value.
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
		int fourOfaKind = 0;
		int twoOfaKind = 0;
		int count = 1;
		int firstValue = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			// Check is current element is equal to next element
			if (arr[i] == arr[i+1]) {
				
				// Begins a loop that breaks if the current element is not equal to the next one
				for (int j = 0; j < 3; j++) {
					if (i == arr.length - 1 || arr[i] != arr[i+1]) {
						break;
					}
					count++;
					i++;
				}
				
				// Recored if there were three or more consecutive elements, but not same the
				// same as the last consecutive three
				if (count >= 4 && arr[i-1] != firstValue) {
					fourOfaKind++;
					firstValue = arr[i-1];
				}
				else if (count >= 2 && arr[i-1] != firstValue) {
					twoOfaKind++;
					firstValue = arr[i-1];
				}
				count = 1;
				
			}
			
		}
		
		return (fourOfaKind > 0 && twoOfaKind > 0) || fourOfaKind > 1;
	}
	
}
