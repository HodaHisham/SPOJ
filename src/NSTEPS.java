
/**
 * @(#)numberSteps.java
 *
 *
 * @author
 * @version 1.00 2015/11/24
 */
import java.io.*;
import java.util.*;

public class NSTEPS {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == y || (x > y && x - y == 2))
				if (x % 2 == 1)
					System.out.println(x + y - 1);
				else
					System.out.println(x + y);
			else
				System.out.println("No Number");

		}
	}
}