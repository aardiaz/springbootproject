package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		
     
	 
		getvalue().forEach(System.out::println);
		
		// references.
				Stream.of("a1", "a2", "a3", "a1")
					.distinct()
					.forEach(System.out::println);
				
				Arrays.stream(new int[] { 1, 2, 3 })
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println);
				
				 
	}
	
	static Stream<String> getvalue() {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		return myList
					.stream()
					.filter(s -> s.startsWith("c")) 
					.map(String::toUpperCase)
					.sorted();	}
	
	
	void foo(List<String> strings) {
		  strings.stream()
		      .map(
		          a -> {
		            String abc;
		            abc = a.replace("a", "*");
		            return abc;
		          });
		     // .collect(Collectors.toList());
		}

}
