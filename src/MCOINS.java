import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class MCOINS {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int k = bf.nextInt(), l = bf.nextInt(), m = bf.nextInt();
		int[] coins = new int[m];
		int[][] memo = new int[(int) 1e6 + 1][2];
		memo[0][0] = 0; // 1 represents winning 0 losing
		memo[0][1] = 0;
		BitSet b = new BitSet(2);
		for (int i = 1; i < memo.length; i++) {
			for (int j = 0; j < 2; j++) {
				b.clear();
				if (i - 1 >= 0)
					b.set(memo[i - 1][1 - j]);
				if (i - k >= 0)
					b.set(memo[i - k][1 - j]);
				if (i - l >= 0)
					b.set(memo[i - l][1 - j]);
				if (b.get(0))
					memo[i][j] = 1;
				else
					memo[i][j] = 0;
			}
		}
		for (int i = 0; i < coins.length; i++) {
			sb.append(memo[bf.nextInt()][0] == 1 ? "A" : "B");
		}
		out.println(sb);
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