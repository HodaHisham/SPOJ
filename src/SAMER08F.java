
/**
 * @(#)Feynman.java
 *
 *
 * @author
 * @version 1.00 2015/11/24
 */
import java.io.*;
import java.util.*;

public class SAMER08F {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		while (N > 0) {
			System.out.println(N * (N + 1) * (2 * N + 1) / 6);
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
		}
	}
}