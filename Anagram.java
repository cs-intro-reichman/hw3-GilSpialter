/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		char c;
        String firstHalf, secondHalf;
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		for (int i = 0; i < str1.length(); i++) {									//running through string 1
			c = str1.charAt(i);
			while (c == 32) {															
				str1 = str1.substring(0, i) + str1.substring(i+1);		//if char is " ", skip over
				c = str1.charAt(i);
			}
			if (str2.indexOf(c) == -1) {											//if char isnt in string 2 - return false
				return false;
			}
			else {																	//if char is   in string 2 - remove from string 2
           	    firstHalf = str2.substring(0, str2.indexOf(c));			
           	    secondHalf = str2.substring(str2.indexOf(c) + 1 , str2.length());
				str2 = firstHalf + secondHalf;
			}
		}

		for (int j = 0; j < str2.length(); j++) {									//if there is a char  in string 2 that isnt " " - return false
			if (str2.charAt(j) != 32)	{
				return false;
			}
		}
        return (true);																//otherwise return true
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"
	public static String preProcess(String str) {
		String s = "";
		str = str.toLowerCase();
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if ((97 <= c && c <= 122) || c == 32 ) {
				s = s + c;
			}
		}
		return s;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String s = "";
		int r, l;
		while (str.length() !=0 ) {
			l = str.length();
			r = (int) (Math.random() * l);
			s = s + "" + str.charAt(r);
			str = str.substring( 0, r ) + str.substring( r + 1, str.length() );
		}
		return s;
	}
}
