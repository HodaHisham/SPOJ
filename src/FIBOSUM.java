import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FIBOSUM {
	static HashMap<Integer, Long> mp;
	static int mod = (int) 1e9 + 7;

	static long fib(int n) {
		if (mp.containsKey(n))
			return mp.get(n);
		long ans = 0;
		int k = n >> 1;
		long a = fib(k), b = fib(k + 1);
		if (n % 2 == 0)
			ans = (a * ((2 * b % mod - a + mod) % mod)) % mod;
		else
			ans = ((a * a) % mod + (b * b) % mod) % mod;
		mp.put(n, ans);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		mp = new HashMap<>();
		mp.put(0, 0L);
		mp.put(1, 1L);
		mp.put(2, 1L);
		while (TC-- > 0) {
			int n = bf.nextInt(), m = bf.nextInt();
			out.println((0L + fib(m + 2) - fib(n + 1) + mod) % mod);
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
