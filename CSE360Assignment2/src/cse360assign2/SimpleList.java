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

	// Constructor to create integer array of size 10 and set count to 0.
	public SimpleList() {
		list = new int[10];
		count = 0;
	}

	/**
	 * Method to add parameter to array index 0. Shifts indexes to the right by one,
	 * unless array is full. If full, drops the last integer off.
	 * 
	 * @param numToAdd Integer to add to array
	 */
	public void add(int numToAdd) {
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
	 * count will be reduced accordingly.
	 * 
	 * @param intToRemove The integer that will be removed
	 */
	public void remove(int intToRemove) {
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

	// toString (): String – Return the list as a String. The elements must be
	// separated by a space. This means there is no space after the last integer.

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
} // end of SimpleList class
