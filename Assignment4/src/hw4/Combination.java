package hw4;

import java.util.ArrayList;

/**
 * Group of dice for a dice game such as MaxiYatzy in which 
 * multiple rolls per turn are allowed.  The dice are partitioned
 * into "available" dice and "complete" dice.  The available
 * dice can be re-rolled (that is, they can get new values via the
 * <code>update</code> method). The client can select which dice 
 * to move from available to complete.
 * Once all dice are complete, as determined
 * by the <code>isComplete()</code> method, the <code>getAvailable()</code>
 * method always returns an empty array, and the state of the
 * combination can no longer be modified.
 * 
 * @author Joseph B. Hennings
 */
public class Combination {
	
	private int numDice;
	private ArrayList<Integer> Completed = new ArrayList<Integer>();
	private ArrayList<Integer> Available = new ArrayList<Integer>();
	
	/**
	 * Constructs a new Combination in which each die initially has 
	 * the (invalid) value zero and all dice are available. In normal usage, 
	 * a client would replace the available die values with randomly generated
	 * numbers in an appropriate range, to simulate rolling the dice.
	 * @param numDice
	 *   number of dice in this group
	 */
	public Combination(int numDice) {
		this.numDice = numDice;
		
		for (int i = 0; i < numDice; i++) {
			Available.add(0);
		}
	}   

	/**
	 * Constructs a new Combination in which each die initially has 
	 * the value given by the <code>initialValues</code> array.
	 * All dice are initially available. The number of dice is determined
	 * by the size of the given array.
	 * <p>
	 * This version of the constructor is primarily intended for testing.
	 * @param initialValues
	 *   initial values for the dice
	 */
	public Combination(int[] initialValues) {
		for (int i = 0; i < initialValues.length; i++) {
			Available.add(initialValues[i]);
		}
	}  

	/**
	 * Returns the number of dice in this group.
	 * @return
	 *   number of dice in this group
	 */
	public int getNumDice() {
		return numDice;
	}

	/**
	 * Selects a die value to be moved from the available dice to the
	 * completed dice. Has no effect if the given value is 
	 * not among the values in the available dice. 
	 * @param value
	 *   die value to be moved
	 */
	public void choose(int value) {
		for (int i = 0; i < Available.size(); i++) {
			
			if (Available.get(i) == value) {
				Available.remove(i);
				Completed.add(value);
				break;
			}
			
		}
	}

	/**
	 * Causes all die values be moved from the available dice to the
	 * completed dice. After this method is called, <code>getAvailable</code>
	 * always returns an empty array, and <code>isComplete</code> returns true.
	 */
	public void chooseAll() {
		for (int i = 0; i < Available.size(); i++) {
			Completed.add(Available.get(i));
		}
		Available.clear();
	}

	/**
	 * Determines whether there are any dice available to be 
	 * rolled in this combination.
	 * @return
	 *   true if there are no available dice, false otherwise
	 */
	public boolean isComplete() {
		return Available.isEmpty();
	}

	/**
	 * Returns the values of the dice that are not available
	 * to be re-rolled, in ascending order.
	 * @return
	 *   values of the dice that are not available to be re-rolled
	 */
	public int[] getCompletedDice() {
		// Return array
		int[] arr = new int[Completed.size()];
		
		// Copy contents
		for (int i = 0; i < Completed.size(); i++) {
			arr[i] = Completed.get(i);
		}
		
		// Sort new array
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
			
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			
			}
		}
		
		return arr;
	}

	/**
	 * Returns the values of the dice that are available to
	 * be re-rolled, in ascending order.
	 * @return
	 *   dice that are available to be re-rolled
	 */
	public int[] getAvailableDice() {
	
		// Return array
		int[] arr = new int[Available.size()];
		
		// Copy contents
		for (int i = 0; i < Available.size(); i++) {
			arr[i] = Available.get(i);
		}
		
		// Sort
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
			
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			
			}
		}
		
		
		
		return arr;
	}

	/**
	 * Returns all die values in this combination, in ascending order.
	 * @return
	 *   all die values in this group
	 */
	public int[] getAll() {
		
		int[] arr = new int[Available.size() + Completed.size()];
		int index = 0;
		
		//Copy contents of Available
		for (int i = 0; i < Available.size(); i++) {
			arr[i] = Available.get(i);
			index++;
		}
		// Copy contents of Completed
		for (int i = 0; i < Completed.size(); i++) {
			arr[index] = Completed.get(i);
			index++;
		}
		
		// Sort
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}
		
		return arr;
	}

	/**
	 * Replaces the available dice with the given values.
	 * Throws an IllegalStateException if the length of
	 * the given array does not match the number of available
	 * dice in this Combination.
	 * @param newValues 
	 *   array of new die values for available dice
	 * @throws IllegalStateException
	 *   if the given array has the wrong length
	 */
	public void updateAvailableDice(int[] newValues) {
		// Throws an exception if length of 'newValues' does not match the size of 'Available'
		if (newValues.length != Available.size()) {
			IllegalStateException e = new IllegalStateException("Length of given array must equal number of available dice.");
			throw e;
		}
		// Clear the list and add new values
		else {
			int numValues = Available.size();
			Available.clear();
			
			for (int i = 0; i < numValues; i++) {
				Available.add(newValues[i]);
			}
		}
	}

	/**
	 * Returns a string representation of the die values in
	 * this combination, in the form <em>available</em>(<em>complete</em>).
	 * (For example, if there are two completed dice with values 2
	 * and 4, and there are 3 available dice with values 1, 1, and 6,
	 * then the method returns the string
	 * <pre>
	 * 1 1 6 (2 4)
	 * </pre>
	 * @return 
	 *   string representation of the available and completed dice,
	 *   with the completed values in parentheses
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		int[] avail = getAvailableDice();
		int[] completed = getCompletedDice();
		if (avail.length > 0)
		{
			for (int value : avail)
			{
				sb.append(value + " ");
			}
		}
		sb.append("(");
		if (completed.length > 0)
		{
			// use an index so we can add the first one without a leading space
			sb.append(completed[0]);
			for (int i = 1; i < completed.length; ++i)
			{
				sb.append(" " + completed[i]);
			}
		}
		sb.append(")");
		return sb.toString();
	}
  
}
