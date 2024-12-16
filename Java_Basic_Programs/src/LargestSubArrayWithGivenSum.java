
public class LargestSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 0, 7, 9, 2, 4, 2 };
		int req_sum = 8;

		int result = largestSubarrayWithGivenSum(arr, req_sum);
//		int result = smallestSubarrayWithGivenSum(arr, req_sum);

		if (result == -1) {
			System.out.println("No subarray found with the given sum.");
		}
	}

	public static int largestSubarrayWithGivenSum(int[] arr, int req_sum) {

		int maxLength = -1; // To track the length of the largest subarray
		int startIndex = -1; // To store the starting index of the largest subarray
		int endIndex = -1; // To store the ending index of the largest subarray

		for (int i = 0; i < arr.length; i++) {
			int sum = 0; // Reset sum for each new starting index
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == req_sum) {
					int currentLength = j - i + 1;
					// Update maxLength and indices if this subarray is larger
					if (currentLength > maxLength) {
						maxLength = currentLength;
						startIndex = i;
						endIndex = j;
					}
				}
			}
		}

		// If maxLength is still -1, no subarray was found
		if (maxLength == -1) {
			return -1;
		} else {
			System.out.println("The largest subarray with sum " + req_sum + " starts at index " + startIndex
					+ " and ends at index " + endIndex + ", and the length is " + maxLength + ".");
			return maxLength;
		}
	}
	
	 public static int smallestSubarrayWithGivenSum(int[] arr, int req_sum) {
	        
	        int minLength = Integer.MAX_VALUE; // To track the length of the smallest subarray
	        int startIndex = -1; // To store the starting index of the smallest subarray
	        int endIndex = -1;   // To store the ending index of the smallest subarray
	        
	        for (int i = 0; i < arr.length; i++) {
	            int sum = 0; // Reset sum for each new starting index
	            for (int j = i; j < arr.length; j++) {
	                sum += arr[j];
	                if (sum == req_sum) {
	                    int currentLength = j - i + 1;
	                    // Update minLength and indices if this subarray is smaller
	                    if (currentLength < minLength) {
	                        minLength = currentLength;
	                        startIndex = i;
	                        endIndex = j;
	                    }
	                    // Break out of the inner loop to skip larger subarrays starting from 'i'
	                    break;
	                }
	            }
	        }

	        // If minLength is still Integer.MAX_VALUE, no subarray was found
	        if (minLength == Integer.MAX_VALUE) {
	            return -1;
	        } else {
	            System.out.println("The smallest subarray with sum " + req_sum + " starts at index " 
	                               + startIndex + " and ends at index " + endIndex 
	                               + ", and the length is " + minLength + ".");
	            return minLength;
	        }
	    }
	}


