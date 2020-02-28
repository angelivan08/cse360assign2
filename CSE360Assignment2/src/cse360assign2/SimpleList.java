package cse360assign2;

/**
 * @author Angel Garcia, Class ID 108, Assignment1
 * 
 *         SimpleList class creates an array of up to 10 integers. User can
 *         interact with array using add, remove, count, toString and search
 *         methods
 *
 *
 */

public class SimpleList {

	/**
	 * Create variable count to keep running total of integers in array Create array
	 * of integers named list
	 *
	 */

	private int count;
	private int list[];
	private int sizeArray = 10;

	// Constructor to create integer array of size 10 and set count to 0.
	public SimpleList() {
		list = new int[sizeArray];
		count = 0;
	}

	/**
	 * Method to add parameter to array index 0. Shifts every index except 0 to the
	 * right by one. If array full, create new array with 50% bigger size. Increase
	 * count by 1
	 * 
	 * @param numToAdd Integer to add to array
	 */

	public void add(int numToAdd) {

		int newSize;

		if (count == sizeArray) {
			newSize = sizeArray + sizeArray / 2;

			// Create array with new Size
			int[] newList = new int[newSize];

			for (int iterator = 0; iterator < count; iterator++) {
				newList[iterator] = list[iterator];
			}

			list = newList;
		}

		if (count == 0) {
			list[count] = numToAdd;
			count++;

		} else if (count < 10) {
			for (int iterator = count - 1; iterator >= 0; iterator--) {
				list[iterator + 1] = list[iterator];
			}
			list[0] = numToAdd;
			count++;
		} else {
			for (int iterator = count - 2; iterator >= 0; iterator--) {
				list[iterator + 1] = list[iterator];
			}
			list[0] = numToAdd;
		}

	}

	/**
	 * Method to remove integer from array. Remaining integers will shift left,
	 * count will be reduced accordingly. If list has >25% empty places, decrease
	 * size of the list, capping at 1 entry
	 * 
	 * @param intToRemove The integer that will be removed
	 */
	public void remove(int intToRemove) {

		int newSize;

		for (int iterator = 0; iterator < count; iterator++) {
			if (list[iterator] == intToRemove) {
				for (int iterator2 = iterator; iterator2 < count - 1; iterator2++)
					list[iterator2] = list[iterator2 + 1];

				count--;

				iterator--;

			}
		}
	}

	/**
	 * Method to return the number of elements in array
	 * 
	 * @return Will give the number of elements in array
	 */
	public int count() {
		return count;
	}

	/**
	 * Method to return elements of the array as a String where elements are
	 * separated with a space
	 * 
	 */
	public String toString() {
		String theString = ""; // Initialize the string

		// Loop to add elements followed by a space, except for last element
		for (int iterator = 0; iterator < count - 1; iterator++) {
			theString = theString + list[iterator] + " ";
		}

		// Adds last element with no space
		if (count != 0)
			theString = theString + list[count - 1];

		return theString;
	}

	/**
	 * Method to search array for an integer. Returns first location of the integer
	 * in the array, and returns -1 if integer not found
	 * 
	 * @param numToSearch The number that will be searched for
	 * @return Returns first location where element was found, but if element was
	 *         not round, return -1
	 */
	public int search(int numToSearch) {
		int numberLocation = -1;
		for (int iterator = 0; iterator < count; iterator++) {
			if (list[iterator] == numToSearch) {
				numberLocation = iterator;
			}
		}
		return numberLocation;
	}

	/**
	 * Returns the first element in the list, returns -1 if list is empty
	 * 
	 * @return Returns element at first location of array
	 */
	public int first() {
		int elementFirst = -1;

		if (count > 0) {
			elementFirst = list[0];
		}
		return elementFirst;
	}

	/**
	 * Returns the last element in the list, returns -1 if list is empty
	 * 
	 * @return Returns element at last location of array
	 */
	public int last() {
		int elementLast = -1;

		if (count > 0) {
			elementLast = list[count - 1];
		}
		return elementLast;
	}

	/**
	 * Returns number of elements in array
	 * 
	 * @return Returns number of elements in array
	 */
	public int size() {
		return count;
	}
} // end of SimpleList class
