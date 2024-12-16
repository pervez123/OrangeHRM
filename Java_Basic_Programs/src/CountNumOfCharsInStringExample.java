import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNumOfCharsInStringExample {

	static void characterCount(String inputString) {

		HashMap<Character, Integer> hash_map = new HashMap<>();
		char[] strArray = inputString.toCharArray();

		for (char c : strArray) {
			if (hash_map.containsKey(c)) {
				hash_map.put(c, hash_map.get(c) + 1);
			}

			else {
				hash_map.put(c, 1);
			}

		}
// Print the hashmap object which gives the number of each character in String.
		System.out.println(hash_map);

// To check duplicate characters in a string
		hash_map.forEach((key, value) -> {

			if (value > 1) {
//				System.out.println("Duplicate character are : " + key);
				System.out.print(key+ ""+value);
			}
		});
	}

	public static void characterCountByStream(String str) {
		String[] a = str.split("");
		Map<String, Long> output = Arrays.stream(a)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("The output with characterCountByStream method: " + output);
	}

	public static void main(String[] args) {
// Input value which needs to be passed in the below method.
		characterCount("aaabbbbcc");
		characterCountByStream("rahulshettyacademy");

	}

}