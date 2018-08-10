package Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lamda {
	public static void main(String args[]) {
		List<String> name = new ArrayList<String>();
		name.add("Abhijeet");
		name.add("Tushar");
		name.add("Pradeep");
		// System.out.println(transform(name,doit(4));
		name.forEach(System.out::println);
		name.forEach( xx -> System.out.println( xx ));
		List<String> temp = allMatches(name, s -> s.length() > 6);
		System.out.println(temp);
	}

	public static List<String> allMatches(List<String> names, Predicate<String> condition) {
		List<String> xx = new ArrayList<String>();
		for (String x : names) {
			if (condition.test(x))
				xx.add(x);
		}
		return xx;

	}
}
// do the same with generics 