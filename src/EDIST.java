import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EDIST {
	static int[][] memo;
	static char[] a, b;

	static int dp(int i, int j) {
		if (i == a.length)
			return b.length - j;
		if (j == b.length)
			return a.length - i;
		if (memo[i][j] != -1)
			return memo[i][j];
		int ans = Math.min(dp(i + 1, j + 1) + (a[i] == b[j] ? 0 : 1), 1 + Math.min(dp(i + 1, j), dp(i, j + 1)));

		return memo[i][j] = ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			a = bf.next().toCharArray();
			b = bf.next().toCharArray();
			memo = new int[a.length + 1][b.length + 1];
			for (int[] i : memo)
				Arrays.fill(i, -1);
			out.println(dp(0, 0));
		}
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
