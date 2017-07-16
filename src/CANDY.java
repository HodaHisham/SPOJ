
/**
 * @(#)candy1.java
 *
 *
 * @author
 * @version 1.00 2015/11/25
 */
import java.io.*;
import java.util.*;

public class CANDY {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		while (n != -1) {
			int sum = 0;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				a[i] = x;
				sum += x;
			}

			double y = (double) sum / n;
			if (y % 1 == 0) {
				int moves = 0;
				for (int i = 0; i < n; i++)
					moves += Math.max(0, (a[i] - y));
				System.out.println(moves);
			} else
				System.out.println(-1);
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
		}
	}
}