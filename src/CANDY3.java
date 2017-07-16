
/**
 * @(#)candy3.java
 *
 *
 * @author
 * @version 1.00 2015/11/25
 */

import java.io.*;
import java.util.*;

public class CANDY3 {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		long sum = 0;
		while (t-- > 0) {
			bf.readLine();
			st = new StringTokenizer(bf.readLine());
			long n = Long.parseLong(st.nextToken());
			sum = 0;
			for (int i = 0; i < n; i++) {
				sum += Long.parseLong(bf.readLine());
				sum %= n;
			}
			String out = "";
			out = sum % n == 0 ? "YES" : "NO";
			System.out.println(out);
		}
	}
}