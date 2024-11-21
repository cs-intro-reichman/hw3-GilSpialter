// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4 
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6 = 0
   		System.out.println(sqrt(36));			//        = 6
		System.out.println(sqrt(263169)); 	//        = 513
   		System.out.println(sqrt(76123));		//        = 275
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1 ++;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				x1 --;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1 --;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				x1 ++;
			}
		}
		return x1;
	}
																	///////check mistakes in ghit from here on out
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		int q = 1;

		if (x2 < 0) {
			q = -1;
		}

			for (int i = 0; i < Math.abs(x2); i++) {
				sum = plus(sum, x1);
			}		
		return q * sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		for (int i = 0; i < n; i++) {
			sum = times(sum, x);
		}		
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0, sum = 0;
		int q;

		if (x1 * x2 >= 0) { 
				q = 1;  }
		else {	q = -1; }

		while (sum + Math.abs(x2) <= Math.abs(x1)) {
			sum = plus (sum, Math.abs(x2));
			counter++;
		}
		return q * counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1 >= x2) {
			x1 = minus (x1, x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if ( x < 0 ) {
			return -1;
		}
		int sq = 0;
		while (pow(sq, 2) <= x) {
			sq ++;
		}
		sq--;
		return sq;
	}	  	  
}