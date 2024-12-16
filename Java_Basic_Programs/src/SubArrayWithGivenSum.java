import java.util.HashMap;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		
		int[] arr = {1,2,5,7,9,4,4,12};
		int sum = 8;
		SubArrayEqualsToGivenSum(arr,sum);
		
	}
	
	public static void SubArrayEqualsToGivenSum(int[] arr, int sum) {
		
		
		int currentSum = 0;
		int start = 0;
		int end = -1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++)
		{
			currentSum += arr[i];
			if(currentSum == sum)
			{
				start = 0;
				end = i;
				break;
			}
			
			if (hm.containsKey(currentSum-sum))
			{
				start = hm.get(currentSum-sum)+1;
				end = i; 
				break;
			}
			else
				hm.put(currentSum, i);
		
		}
		
		if(end == -1)
		{
			System.out.println("No subarray found");
		}
		else
		{
		System.out.println("The subarray starting index is : " + start +" and end index is: "+ end);
		
		}
	}

}
