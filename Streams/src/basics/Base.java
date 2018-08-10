package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Base {

	public static void main(String[] args) {
		List<String> name = new ArrayList<String>();
		name.add("Abhijeet");
		name.add("Tushar");
		name.add("Pradeep");
		name.forEach( x -> {System.out.println("  "+x); } );
		System.out.println("question two printig values");
		name.forEach( System.out::println );
		
		List<String>answer = name.stream().map( s ->  s + "!" ).collect( Collectors.toList() );
		System.out.println( answer );
		
		List<String>tingtong = name.stream().filter(s -> s.length()>6).collect(Collectors.toList());
		System.out.println(tingtong);
		
		
	}

}
