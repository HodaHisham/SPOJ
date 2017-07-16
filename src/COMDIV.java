import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class COMDIV {
	static ArrayList<Integer> primes;

	static void sieve(int n)
	{
		primes = new ArrayList<>();
		boolean[] comp = new boolean[n + 1];
		comp[0] = comp[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!comp[i]) {
				primes.add(i);
				if (1L * i * i <= n)
					for (int j = i * i; j <= n; j += i) {
						comp[j] = true;
					}
			}
		}
	}

	static long factorize(int n) {
		int idx = 0;
		int p = primes.get(idx);
		long res = 1;
		while (1L * p * p <= n) {
			int tmp = 0;
			while (n % p == 0) {
				tmp++;
				n /= p;
			}
			res *= (tmp + 1);
			p = primes.get(++idx);
		}
		if (n != 1)
			res *= 2;
		return res;
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		sieve((int) 1e6);
		StringBuilder sb = new StringBuilder();
		while (TC-- > 0) {
			int a = bf.nextInt(), b = bf.nextInt();
			sb.append(factorize(gcd(a, b))).append("\n");
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
