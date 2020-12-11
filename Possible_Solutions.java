public class Possible_Solutions{
	/**
	 * This method receives a number and prints all the sets of values for x1, x2,
	 * x3 from 1 to 10 that fit the equation: x1+x2+x3 = received number, and
	 * returns the amount of these sets. The method is recursive, because it uses
	 * the recursive methods solutionsI, solutionsJ and solutionsK.
	 * 
	 * The run-time complexity of this method is O(1), because the run-time of each
	 * recursive helping method is a constant(10), therefore the run time of this
	 * method is also a constant(10*10*10=1000). The space Complexity is O(1)
	 * because there is a constant number of variables stored in the memory for 
	 * this method.
	 * 
	 * @param sum is the number to which the equation should equal.
	 * @return the number of answers to the equation.
	 */

	public static int solutions(int sum) {
		if (sum > 30 || sum < 3) {
			return 0;
		}
		return solutionsI(1, sum, 0);
	}

	// This method helps the method "solutions" to find all the options for x1,
	// and calls the method solutionsJ.
	public static int solutionsI(int i, int sum, int count) {
		if (i == 11)
			return count;
		count = solutionsJ(i, 1, sum, count);
		return solutionsI(i + 1, sum, count);
	}

	// This method helps the method "solutions" to find all the options for x2,
	// and calls the method solutionsK.
	public static int solutionsJ(int i, int j, int sum, int count) {
		if (j == 11)
			return count;
		count = solutionsK(i, j, 1, sum, count);
		return solutionsJ(i, j + 1, sum, count);
	}

	// This method helps the method "solutions" to find, to count and to print all the options for x3.
	public static int solutionsK(int i, int j, int k, int sum, int count) {
		if (k == 11)
			return count;
		if ((i + j + k) == sum) {
			count++;
			System.out.println(i + " + " + j + " + " + k);
		}
		return solutionsK(i, j, k + 1, sum, count);
	}
}