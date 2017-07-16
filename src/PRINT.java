import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PRINT {

	static boolean prime[];
	static ArrayList<Integer> primes;

	public static void sieve(int n) {
		prime = new boolean[n + 1];
		primes = new ArrayList<Integer>();
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				primes.add(i);
				if (1L * i * i < n + 1)
					for (int j = i * i; j < prime.length; j += i) {
						prime[j] = false;
					}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sieve((int) 1e5);
		int TC = bf.nextInt();
		StringBuilder sb = new StringBuilder();
		while (TC-- > 0) {
			int l = bf.nextInt(), u = bf.nextInt();
			boolean[] b = new boolean[u - l + 1];
			Arrays.fill(b, true);
			if (l == 1)
				b[0] = false;
			for (int p : primes) {
				if (1L * p * p > u)
					break;
				long t = 1L * (l / p + (l % p == 0 ? 0 : 1)) * p;
				if (t > u)
					continue;
				int n = (int) t;
				if (n == p || n == 1)
					n = 2 * p;
				for (int i = n - l; i >= 0 && i < b.length; i += p) {
					b[i] = false;
				}
			}
			for (int i = 0; i < b.length; i++) {
				if (b[i])
					sb.append((i + l)).append("\n");
			}
		}
		out.print(sb);
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
