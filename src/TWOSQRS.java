import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TWOSQRS {
	static ArrayList<Integer> primes;
	static int[] isComposite;

	static void sieve(int N) {
		isComposite = new int[N + 1];
		isComposite[0] = isComposite[1] = 1;
		primes = new ArrayList<Integer>();

		for (int i = 2; i <= N; ++i)
			if (isComposite[i] == 0) {
				primes.add(i);
				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)
						isComposite[j] = 1;
			}
	}

	static boolean primeFactors(long N) {
		int idx = 0, p = primes.get(idx);
		boolean res = true;
		while (1L * p * p <= N && res) {
			int tmp = 0;
			while (N % p == 0) {
				tmp++;
				N /= p;
			}
			if ((tmp & 1) != 0 && p % 4 == 3)
				res = false;
			p = primes.get(++idx);
		}
		if (N != 1)
			if (N % 4 == 3)
				res = false;
		return res;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		sieve((int) 1e6);
		while (TC-- > 0) {
			long n = bf.nextLong();
			out.println(n <= 1 || primeFactors(n) ? "Yes" : "No");
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