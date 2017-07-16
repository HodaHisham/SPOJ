import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ELIS {
	static int lis(int[] A, int n) {
		ArrayList<Integer> L = new ArrayList<Integer>();

		int lis = 0;
		for (int i = 0; i < n; ++i) {
			int pos = Collections.binarySearch(L, A[i]);
			if (pos < 0)
				pos = -(pos + 1);
			// else pos++; non-decreasing

			if (pos >= L.size())
				L.add(A[i]);
			else
				L.set(pos, A[i]);

			if (pos + 1 > lis) {
				lis = pos + 1;
			}

		}

		return lis;
	}

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = bf.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = bf.nextInt();
		}
		out.println(lis(a, n));
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}