import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ETF {
	static int phi(int N) {
		int ans = N, idx = 0, p = primes.get(0);
		while (1L * p * p <= N) {
			if (N % p == 0)
				ans -= ans / p;
			while (N % p == 0)
				N /= p;
			p = primes.get(++idx);
		}

		if (N != 1)
			ans -= ans / N;
		return ans;
	}

	static ArrayList<Integer> primes;
	static int[] isComposite;

	static void sieve(int N) // O(N log log N)
	{
		isComposite = new int[N + 1];
		isComposite[0] = isComposite[1] = 1; // 0 indicates a prime number
		primes = new ArrayList<Integer>();

		for (int i = 2; i <= N; ++i) // can loop till i*i <= N if primes array
										// is not needed O(N log log sqrt(N))
			if (isComposite[i] == 0) // can loop in 2 and odd integers for
										// slightly better performance
			{
				primes.add(i);
				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i) // j = i * 2 will not
														// affect performance
														// too much, may alter
														// in modified sieve
						isComposite[j] = 1;
			}
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		sieve((int) 1e6);
		while (TC-- > 0) {
			int n = bf.nextInt();
			out.println(phi(n));
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
