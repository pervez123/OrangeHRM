import java.util.Scanner;


//Logic - 
//Perfect number is a number 
//whose divisors(except number itself) sum is equal to the number

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: "); 
		int num =  in.nextInt();
		int sum = 0;
		for (int i=1; i<num; i++)
		{
			if (num%i==0) {
				sum += i;
			}
		}
		if (sum==num) {
			System.out.println("Perfect number");
		}
		else {
			System.out.println("Not a perfect number");
		}
		

	}

}
