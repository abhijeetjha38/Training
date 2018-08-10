package demo;

public class Bingo {
	
	public static void main( String args[] ) {
		Hello xx = ()->System.out.println("yuhhhooo");
		gg tt = (x) -> {
			return 2*x ;
		};
		xx.doit();
		System.out.println(tt.func(22));
	}
}

