import java.util.Scanner;

public class Febonacii_Series {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter number: ");
	int fiboLength = sc.nextInt();
	febonacciSeriesbySwapping(fiboLength);
	System.out.println("\n");
	febonacciSeriesUsingArray(fiboLength);
	
	}
	
	public static void febonacciSeriesbySwapping(int fiboLength) {
	
		int num1 = 0, num2 = 1;
		System.out.print("Febonacii By Swapping: " + num1 + "," + num2);
		int febo;
		for(int i=2; i<fiboLength; i++) {
			
			febo = num1 + num2;
			System.out.print("," + febo);
			num1 = num2;
			num2 = febo;
			
		}
	}
		
//	Array method

	public static void febonacciSeriesUsingArray(int fiboLength) {
		
		int num[] = new int[fiboLength];

		num[0] = 0;
		num[1] = 1;
		System.out.print("Febonacii By Array: " + num[0]+","+num[1]);
		
		for(int i=2; i<fiboLength; i++) {
			
			num[i] = num[i-1] + num[i-2];
			System.out.print("," +num[i]);
		}
	

	}
	

}
