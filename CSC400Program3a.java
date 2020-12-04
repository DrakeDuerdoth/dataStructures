package homework402;

import java.util.Arrays;
import stdlib.*;

/**
 * Version 1.0
 * 
 *   Your Name goes here
 *   You class section  goes here
 *   
 *   
 * This is a skeleton file for your homework. Edit the sections marked TODO. 
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you would get zero points if you change the line
 * <pre>
 *     public static double minValue (double[] list) {
 * </pre>
 * to something like
 * <pre>
 *     public static void minValue (double[] list) {
 * </pre>
 * or
 * <pre>
 *     public static double minValue (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes unless otherwise indicated. 
 * You should not use any HashSets or ArrayLists, or anything else! 
 * In addition, each of your functions should go
 * through the argument array at most once. The only exception to this is
 * removeDuplicates, which is allowed to call numDuplicates and then go through the
 * array once after that.
 */
public class CSC400Program3a {

	/**
	 * numDuplicates returns the number of duplicate values in an array of characters.
	 * Precondition: the array may be empty, but if it is not empty the array is sorted from low to high.
	 *                            { your solution can assume this is true }
	 *
	 * Your solution may go through the array exactly once. Your solution must
	 * not call any other functions. Here are some examples (using "=="
	 * informally):
	 *
	 * <pre>
	 *     0 == numDuplicates(new char[] { })
	 *     0 == numDuplicates(new char[] { 'a' })
	 *     3 == numDuplicates(new char[] { 'a', 'a', 'a', 'a' })
	 *     9 == numDuplicates(new char[] { 'a', 'a', 'a', 'a', 'b', 'd', 'g', 'g', 'g', 'g', 'g', 'h', 'h', 'm', 'p', 't', 't' })
	 *     5 == numDuplicates(new char[] { 'a', 'b', 'd', 'g', 'g', 'g', 'g', 'g', 'h', 'h', 'm', 'p', 't' })
	 * </pre>
	 */
	public static int numDuplicates (char[] list) {
		return -1; //TODO1: fix this
	}

	/**
	 * removeDuplicates returns a new array containing the unique values in the
	 * array. There should not be any extra space in the array --- there should
	 * be exactly one space for each unique element (Hint: numDuplicates can 
	 * help you determine how big the array should be). 
	 * You may assume that the list is sorted, as you did for numDuplicates.
	 *
	 * Your solution may call numDuplicates, but should not call any other
	 * functions. After the call to numDuplicates, you may go through the array
	 * exactly one time. Here are some examples; the left hand side  of "<--"
	 * means that is the returned result from the function call on the right hand side
	 *
	 * <pre>
	 *   new char[] { }      <--    removeDuplicates(new char[] { })
	 *   new char[] { 'a' }  <--    removeDuplicates(new char[] { 'a' })
	 *   new char[] { 'a' }  <--    removeDuplicates(new char[] { 'a', 'a', 'a', 'a' })
     *   new char[] { 'a', 'b', 'd', 'g', 'm', 'p', 't', 'w' }
	 *                <-- removeDuplicates(new char[] { 'a', 'a', 'a', 'a', 'b', 'd', 'g', 'g', 'g', 'g', 'g', 'm', 'm', 'p', 't', 'w', 'w' })
	 * </pre>
	 */
	public static char[] removeDuplicates (char[] list) {

		return list; // TODO: fix this
	}

	/**
	 * A test program, using private helper functions.  See below.
	 * You are encouraged to review the test cases and testing code below, but you should not
	 * change any of the code below.
	 */
	public static void main (String[] args) {		
		// for numUnique: array must be sorted
		
		testNumDuplicates (0, new char[] {});
		testNumDuplicates(0,new char[] {'a'});
		testNumDuplicates(3,new char[] {'a','a','a','a'});
		testNumDuplicates(0,new char[] {'a','b','d','g'});
		testNumDuplicates(5,new char[] {'a','a','a','b','d','d','d','d','g'});
		testNumDuplicates(5,new char[] {'a','b','b','b','d','g','g','g','g'});
		testNumDuplicates(7,new char[] {'a','a','b','b','b','d','d','g','g','g','g'});
		testNumDuplicates(6,new char[] {'a','a','b','d','g','g','g','g','h','h','m','p','t','t'});
		testNumDuplicates(5,new char[] {'a','b','d','g','g','g','g','g','h','h','m','p','t'});
		testNumDuplicates(8,new char[] {'a','a','a','a','b','d','g','g','g','g','g','h','h','m','p'});
		testNumDuplicates(5,new char[] {'a','b','d','g','g','g','g','g','h','h','m','p'});
		testNumDuplicates(7,new char[] {'t','t','t','p','m','h','h','h','g','g','d','b','a','a','a'});

		
		
		// for removeDuplicates: array must be sorted
		testRemoveDuplicates (new char[] {}, new char[] {});
		testRemoveDuplicates (new char[] {'a'}, new char[] {'a'} );  
		testRemoveDuplicates (new char[] {'a'}, new char[] {'a','a','a','a'} );  
		testRemoveDuplicates (new char[] {'a','b','d','g'}, new char[] {'a','b','d','g'} ); 
		testRemoveDuplicates (new char[] {'a','b','d','g'}, new char[] {'a','a','a','b','d','d','d','d','g'} ); 
		testRemoveDuplicates(new char[] {'a','b','d','g'} , new char[] {'a','b','b','b','d','g','g','g','g'} );
		testRemoveDuplicates(new char[] {'a','b','d','g'} , new char[] {'a','a','b','b','b','d','d','g','g','g','g'} );
		testRemoveDuplicates(new char[] {'a','b','d','g','h','m','p','t'} , new char[] {'a','a','a','a','b','d','g','g','g','g','g','h','h','m','p','t','t'} );
		testRemoveDuplicates(new char[] {'a','b','d','g','h','m','p','t'} , new char[] {'a','b','d','g','g','g','g','g','h','h','m','p','t'} );
		testRemoveDuplicates(new char[] {'a','b','d','g','h','m','p'} , new char[] {'a','a','a','a','b','d','g','g','g','g','g','h','h','m','p'} );
		testRemoveDuplicates(new char[] {'a','b','d','g','h','m','p'} , new char[] {'a','b','d','g','g','g','g','g','h','h','m','p'} );
	
		StdOut.println ("Finished tests");

	}

	private static void testNumDuplicates (int expected, char[] list) {

		int actual = numDuplicates  (list);

		if (expected != actual) {
			StdOut.format ("Failed numDuplicates %s: Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testRemoveDuplicates (char[] expected, char[] list) {

		char[] actual = removeDuplicates (list);

		// != operator does not do what we want on arrays, use   equals   function from Arrays  class
		if (! Arrays.equals (expected, actual)) {
			StdOut.format ("Failed removeDuplicates %s: Expecting %s Actual %s\n", Arrays.toString(list), Arrays.toString (expected), Arrays.toString (actual));
		}
	}
}