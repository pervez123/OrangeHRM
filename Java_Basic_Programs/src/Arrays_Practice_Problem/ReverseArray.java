package Arrays_Practice_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

	public static String reverseArray(Integer[] num) {
		
		Collections.reverse(Arrays.asList(num));
		return "Reversed Array : " + Arrays.toString(num);
	}
	public static void main(String[] args) {
	
	
//		        String str = "Java is a programming Language";
//		        String[] lst = str.split(" ");
				Integer[] num = {-10, 2, 7, 8, 1, 3, 2, 0};
		        System.out.println("Original array : " + Arrays.toString(num));
		        System.out.println(reverseArray(num));

		    }
		
	}


