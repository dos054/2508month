package streaM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamEx {

	public static void main(String[] args) {
//		List<String> list = Arrays.asList("김","박","정");
//		for(String str : list) {
//			System.out.println(str);
//		}
//		list.stream().forEach((s)->System.out.println());
		
		IntStream.rangeClosed(1, 10).forEach((i)->{
			System.out.println(i);
		});
		
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		System.out.println("**************");
//		List<String> items = Arrays.asList("김","박","정","김");
//		long count = items.stream()
//				.filter(item -> item.equals("김"))
//				.count();
//		System.out.println(items);
//		System.out.println(count);
		
		List<Integer> nums = Arrays.asList(5,1,9,3);
		int max = nums.stream().max((a,b) -> a-b).get();
		System.out.println(max);
		
	}

}
