
/**
 * @(#)transform.java
 *
 *
 * @author
 * @version 1.00 2015/11/24
 */
import java.io.*;
import java.util.*;

public class ONEP {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			String s = bf.readLine();
			Stack<Character> sk = new Stack<Character>();
			String out = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= 97 && c <= 122)
					out += c;

				else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
					sk.push(c);
				} else if (c == ')') {
					out += sk.pop();
				}
			}
			while (!sk.isEmpty()) {
				out += sk.pop();
			}
			System.out.println(out);
		}

	}
}
