package hw1;

public class AirportVan {
	
	/**
	 * @author Joseph Hennings
	 * Iowa State Student ID 996748810
	 * September 14th, 2023
	 */
	
	private int totalMiles;
	private int totalTime;
	private int totalRiders;
	private int maxRiders;
	private int timeBonus;
	private int mileageBonus;
	private double totalTips;
	private double hourlyRate;
	private double totalPay;
	
	/**
	 * Constructor
	 * @param givenHourlyRate
	 * @param givenMileageBonus
	 * @param givenTimeBonus
	 * @param givenMaxRiders
	 */
	public AirportVan(double givenHourlyRate, int givenMileageBonus, int givenTimeBonus, int givenMaxRiders) {
		hourlyRate = givenHourlyRate;
		mileageBonus = givenMileageBonus;
		timeBonus = givenTimeBonus;
		maxRiders = givenMaxRiders;
	}
	
	/**
	 * Mutator method
	 * @param miles
	 * @param minutes
	 */
	public void drive(int miles, int minutes) {
		totalMiles += miles;
		totalTime += minutes;
	}
	
	//Mutator method
	public void pickUp() {
		totalRiders = Math.min(totalRiders + 1, maxRiders);
	}
	
	/**
	 * Mutator method
	 * @param tip
	 */
	public void dropOff(double tip) {
		tip *= Math.min(1.0, totalRiders);
		totalRiders = Math.max(0, totalRiders - 1);
		totalTips += tip;
	}
	
	/**
	 * Accessor or mutator?
	 * @param dollarsPerPoint
	 * @return
	 */
	public double getAverageHourlyPay(double dollarsPerPoint) {
		return getTotalPay(dollarsPerPoint) / ((double)totalTime / 60.0);
	}
	
	/**
	 * Accessor method
	 * @return
	 * RiderCount
	 */
	public int getRiderCount() {
		return totalRiders;
	}
	
	/**
	 * Accessor method
	 * @return
	 * Total Miles
	 */
	public int getTotalMiles() {
		return totalMiles;
	}
	
	/**
	 * Accessor method
	 * @param dollarsPerPoint
	 * @return
	 * TotalPay
	 */
	public double getTotalPay(double dollarsPerPoint) {
		totalPay = (totalTime / 60.0 * hourlyRate) + (dollarsPerPoint * getTotalPoints()) + totalTips;
		return totalPay;
	}
	
	/**
	 * Accessor method
	 * @return
	 * TotalPoints
	 */
	public int getTotalPoints() {
		int timePoints, milePoints;
		
		timePoints =  totalTime * timeBonus * Math.min(1, totalRiders);// One or more - treated as one
		milePoints = totalMiles * mileageBonus * (Math.max(1, totalRiders));// If van is empty, treated as one
		
		return timePoints + milePoints;
	}
	
	/**
	 * Accessor method
	 * @return
	 * TotalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}
	
	/**
	 * Accessor method
	 * @return
	 * TotalTips
	 */
	public double getTotalTips() {
		return totalTips;
	}
	
	/**
	 * Mutator method
	 * @param minutes
	 */
	public void waitAround(int minutes) {
		totalTime += minutes;
	}
	
}
