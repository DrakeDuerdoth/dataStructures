/* CSC 403
 * 
 * 
 * Get help from anyone?  put that here
 * 
 * Homework 1 Driver 
 * 
 * Instructions:  using sizeTest  as a template, create additional functions to test
 *                the member functions in your LinkedListST implementation.
 *                AND
 *                create a reasonable set of test cases for each; 
 *                call your testing functions from main
 *                
 */
package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class hw1Driver {

		public static void main(String[] args)
		{
			LinkedListST<String, Integer> st = new LinkedListST<>();
			StdIn.fromFile("data/tinyST.txt");
			for (int i = 0; !StdIn.isEmpty(); i++)
			{
				String key = StdIn.readString();
				st.put(key, i);
			}
			for (String s : st.keys())
				StdOut.println(s + " " + st.get(s));
			
			allInverseTests();
			allSizeTests();
			allSecondMaxTest();
			allRankTests();
			allFloorTests();
		}
		public static void allSizeTests() {
			sizeTest("",0);				    // testing an empty ST (symbol table)
			sizeTest("abcdefgh",8);			// test size on a non-empty ST
			sizeTest("iwjwelki",6);         // testing duplicates
			sizeTest("aaaaaaaaaaaa", 1);    // testing duplicates with no other key
			sizeTest("lsdifnweflz", 9);     // testing duplicates	
		}
		public static void allSecondMaxTest(){
			secondMaxTest("yzabcd","y"); //testing with secondMax being the first 
			secondMaxTest("ab", "a"); // testing with only two keys
			secondMaxTest("", null); // empty ST
			secondMaxTest("sfuhfskf", "s"); // secondMax with duplicates
			secondMaxTest("ghjyk","k"); // secondMax last in ST
		}
		public static void allRankTests() {
			rankTest("abcdefghis", 9); // Test edge cases 
			rankTest("weisslaudfhew", 7); // Testing duplicates
			rankTest("sssssssssssss", 0); // Testing duplicates with no other value
		}
		public static void allFloorTests() {
			floorTest("abcuzy", "c");
			floorTest("sihgfedcba", "g");// Testing if edge cases work
			floorTest("weislaudfhew", "f"); // Testing if duplicates aren't counted more than once
			floorTest("ssssssssss", null); // Duplicates with other value
			floorTest("abccccccc", "c"); // Another duplicate test
			floorTest("sefsfsdlfjg", "g"); // Test with g as last
			floorTest("abckfg", "g"); // g as last
			floorTest("yyyyyyya", "a");	// Duplicates + answer as last
		}
		public static void allInverseTests() {
			inverseTest("abcde", "5");
		}
		public static void sizeTest( String vals, int answer ) {
			LinkedListST<String,Integer> aList = new LinkedListST<String,Integer>();
			for (int i=0; i < vals.length(); i++) {
				aList.put(vals.substring(i, i+1),i);
			}
			//  call the size function
			int result = aList.size();
			//report result
			if ( result == answer)  // test passes
				StdOut.format("sizeTest: Correct		String %s 		Answer: %d\n", vals,result);
			else
				StdOut.format("sizeTest: *Error*  		String %s 		Answer: %d\n", vals,result);
		}
		public static void secondMaxTest(String vals, String answer) {
			LinkedListST<String,Integer> secMax = new LinkedListST<String,Integer>();
			for (int i=0; i < vals.length(); i++) {
				secMax.put(vals.substring(i, i+1),i);
			}
			String result = secMax.secondMaxKey();
			StdOut.format("allSecondMaxTests: Correct		String %s		Your Answer: %s		Answer: %s\n", vals, result, answer);
			
			
		}
		public static void rankTest(String vals, int answer) {
			LinkedListST<String,Integer> rankTest = new LinkedListST<String,Integer>();
			for (int i=0; i < vals.length(); i++) {
				rankTest.put(vals.substring(i, i+1),i);
			}
			int result = rankTest.rank("s");
			if( result == answer) StdOut.format("rankTest: Correct 		String %s		Your Answer: %s		Answer: %s\n", vals, result, answer);
			else StdOut.format("rankTest: Try again.	Correct 		String %s		Your Answer: %s		Answer: %s\n", vals, result, answer);
			
		}
		public static void floorTest(String vals, String answer) {
			LinkedListST<String,Integer> tests = new LinkedListST<String,Integer>();
			for (int i=0; i < vals.length(); i++) {
				tests.put(vals.substring(i, i+1),i);
			}
			String result = tests.floor("g");
			
			StdOut.format("floorTest: Correct			String %s		Your Answer: %s		Answer: %s\n", vals, result, answer);
			
						
		}
		public static void inverseTest (String vals, String answer) {
			LinkedListST<String,Integer> aList = new LinkedListST<String,Integer>();
			for (int i=0; i < vals.length(); i++) {
				aList.put(vals.substring(i, i+1),i);
			}
			LinkedListST <Integer,String> bList = aList.inverse(); 
				for(String p: aList.keys()) {
					StdOut.println(p+ " " + aList.get(p)); 
				}


		for(Integer s: bList.keys()) {
			StdOut.println(s+ " " + bList.get(s)); 
		}
	}
}

