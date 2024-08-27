package hw4;

import java.util.ArrayList;
import java.util.Random;

import api.GameConfiguration;
import api.ScoreBox;

/**
 * Game state for dice games such as MaxiYatzy.  The game includes a
 * <code>GameConfiguration</code> object along with two lists of 
 * <code>ScoreBox</code> objects, one for the upper section 
 * and one for the lower section. (Note that the only actual distinction
 * between the two sections is that the upper section scores are 
 * added up and checked to see whether they exceed the upper section 
 * bonus cutoff; if so, the upper section bonus is added to the score.)
 * This class is also responsible for
 * maintaining a current Combination (group of dice) and counting the number of 
 * rolls. 
 * <p>
 * Most of the game state is stored in the associated <code>ScoreBox</code>
 * objects, each of which knows its contribution to the overall
 * score, obtained via its <code>getScore</code> method.
 * 
 * I created an abstract class 'ParentScoreBox' that contains all methods
 * a score box will use except for 'isSatifiedBy'. I went with this approach
 * because almost all score boxes will use the method totally differently,
 * and I quickly saw a trend on most of the other methods. 
 * 
 * @author Joseph B. Hennings
 */
public class MaxiYatzy {
	/**
	 * Private instance of 'GameConfiguration' providing instantiation for this class
	 */
	private GameConfiguration config;
	/**
	 * Private instance of 'Combination' providing combination instantiation for this class
	 */
	private Combination comb;
	/**
	 * Private instance of 'Random' for this class
	 */
	private Random rand;
	/**
	 * Hold the value of max rolls and decrements after each roll
	 */
	private int remainingRolls;
	/**
	 * Private list of 'ScoreBox' objects making up the lower section
	 */
	private ArrayList<ScoreBox> lowerSection = new ArrayList<ScoreBox>();
	/**
	 * Private list of 'ScoreBox' objects making up the upper section
	 */
	private ArrayList<ScoreBox> upperSection = new ArrayList<ScoreBox>();
	
	
	/**
	 * Constructs a new MaxiYatzy game based on the given configuration. 
	 * Initially the upper section and lower section lists are
	 * empty.
	 * @param config
	 *   configuration to use for this game
	 * @param rand
	 *   random number generator to use for rolling dice
	 */
	public MaxiYatzy(GameConfiguration config, Random rand) {
		this.config = config;
		this.rand = rand;
	}

	/**
	 * Adds a score box to the lower section of this game.
	 * @param box
	 *   score box to add
	 */
	public void addLowerSectionScoreBox(ScoreBox box) {
		lowerSection.add(box);
	}

	/**
	 * Adds a score box to the upper section of this game.
	 * @param box
	 *   score box to add
	 */  
	public void addUpperSectionScoreBox(ScoreBox box) {
		upperSection.add(box);
	}

	/**
	 * Returns the list of score boxes in the upper section 
	 * for this game.
	 * @return
	 *   list of score boxes in the upper section
	 */
	public ArrayList<ScoreBox> getUpperSection() {
		return upperSection;
	}

	/**
	 * Returns the list of score boxes in the lower section
	 * for this game.
	 * @return
	 *   list of score boxes for the lower section
	 */
	public ArrayList<ScoreBox> getLowerSection() {
		return lowerSection;
	}

	/**
	 * Starts a new turn by creating a new Combination
	 * and updating the available rolls according to this
	 * game's configuration.  If there is already a
	 * current Combination that is not complete, this
	 * method does nothing.
	 */
	public void startTurn() {
		if (comb == null || comb.isComplete()) {
			remainingRolls += config.getMaxRolls();
			comb = new Combination(config.getNumDice());
		}
	}

	/**
	 * Returns the remaining number of rolls for this turn.
	 * The value returned is always zero if the current Combination
	 * is complete, even if the configuration allows unused
	 * rolls to be saved for future turns.
	 * @return
	 *   number of rolls
	 */
	public int getRemainingRolls() {    
		return remainingRolls;
	}

	/**
	 * Rolls the available dice in the current Combination.
	 * That is, the available die values are replaced by randomly
	 * generated values in the range 1 through the given maximum (according
	 * to this game's configuration). If there are no more remaining
	 * rolls, all available dice in the current Combination are
	 * moved to the completed state.
	 */
	public void rollAvailableDice() {
		
		if (remainingRolls <= 0) {
			comb.chooseAll();
		}
		else {
			int[] arr = comb.getAvailableDice();
			
			// THIS ONLY WORKS RIGHT IF WE REMOVE THE RANDOM SEED
			for (int i = 0; i < arr.length; i++) {
				arr[i] = rand.nextInt(config.getMaxValue()) + 1;
			}
			
			comb.updateAvailableDice(arr);
			
			remainingRolls--;
		}
		
	}

	/**
	 * Returns the current Combination (group of dice).  
	 * @return
	 *   current group of dice
	 */
	public Combination getCurrentDice() {
		return comb;
	}

	/**
	 * Returns true if the game is over.  The game is considered over
	 * when all score boxes are filled.
	 * @return
	 *   true if the game is over, false otherwise
	 */
	public boolean isOver() {
		boolean over = true;
		
		for (int i = 0; i < lowerSection.size(); i++) {
			if (!lowerSection.get(i).isFilled()) {
				over = false;
			}
		}
		for (int i = 0; i < upperSection.size(); i++) {
			if (!upperSection.get(i).isFilled()) {
				over = false;
			}
		}
		
		return over;
	}

	/**
	 * Returns the total score for the filled upper section score boxes
	 * (not including the upper section bonus, if any).
	 * @return
	 *   upper section total score
	 */
	public int getUpperSectionTotal() {
		int score = 0;
		
		for (int i = 0; i < upperSection.size(); i++) {
			score += upperSection.get(i).getScore();
		}
		
		return score;
	}

	/**
	 * Returns the total score for the filled lower section score boxes.
	 * @return
	 *   lower section total score
	 */
	public int getLowerSectionTotal() {
		int score = 0;
		
		for (int i = 0; i < lowerSection.size(); i++) {
			score += lowerSection.get(i).getScore();
		}
		
		return score;
	}

	/**
	 * Returns the total score for all categories including the upper section
	 * bonus, if any.
	 * @return
	 *   total score for all categories
	 */
	public int getTotalScore() {
		return getLowerSectionTotal() + getUpperSectionTotal() + getUpperSectionBonus();
	}

	/**
	 * Returns the upper section bonus if one is currently being applied,
	 * otherwise returns zero. 
	 * @return
	 *    upper section bonus if applicable, otherwise zero
	 */
	public int getUpperSectionBonus() {
		return config.getUpperSectionBonus();
	}

}
