package quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class quiz1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> filtered = numbers.stream()
			.filter(n -> n % 2 ==0)
			.collect(Collectors.toList());
//		numbers.stream().forEach(n -> System.out.println(n));
		filtered.stream().forEach(n -> System.out.println(n));
	
		List<String> words = Arrays.asList("java","lamda","stream");
		words.stream()
			.map(word -> word.toUpperCase())
			.forEach(System.out::println);
	}
	

}
