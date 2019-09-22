// CS272
// Stefanie Gutierrez
// Lab 1: Eclipse tutorial & file operations
// Purpose: practice Java knowledge. 
// 			Learn how to use a new IDE, Eclipse

package lab1;

public class addition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int number = 20;
		int step = 1;
		int summation =0;
		
		for (int i=0; i<number; i++){
			summation+=step;
			step ++;
		}
		
		System.out.println("Summation for number " + number +" is: " + summation);
	}

}
