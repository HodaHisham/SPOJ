import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TRT {
	static int[][] memo;
	static int[] v;

	static int dp(int s, int e) {
		if (s > e)
			return 0;
		if (memo[s][e] != -1)
			return memo[s][e];
		int age = v.length - (e - s);
		int ans = Math.max(age * v[s] + dp(s + 1, e), age * v[e] + dp(s, e - 1));
		return memo[s][e] = ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = bf.nextInt();
		memo = new int[n + 1][n + 1];
		v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = bf.nextInt();
		}
		for (int[] i : memo)
			Arrays.fill(i, -1);
		out.println(dp(0, n - 1));
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
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

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}