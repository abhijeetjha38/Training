
public class Test {
	public static void main(String args[]) {
		String s1 = "zenith";
		String s2 = "xylophone";
		System.out.println(betterString(s1, s2, (x, y) -> x.length() > y.length()));
	}

	public static String betterString(String xx, String yy, Tt decider) {
		if (decider.isFirstBetter(xx, yy))
			return xx;
		return yy;
	}
}

// we can also add generics in the given set !!
// public static <T> BetterElement(T s1 , T s2 , Tt<T> decider)