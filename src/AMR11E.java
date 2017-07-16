import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AMR11E {
	static int[] pf;

	static void numPF(int N) {
		pf = new int[N];
		for (int i = 2; i < N; ++i)
			if (pf[i] == 0)
				for (int j = i; j < N; j += i) {
					pf[j]++;
				}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		StringBuilder sb = new StringBuilder();
		numPF((int) 1e5);
		int[] res = new int[1001];
		for (int i = 0, k = 0; i < pf.length && k < res.length; i++) {
			if (pf[i] >= 3)
				res[k++] = i;
		}
		while (TC-- > 0) {
			sb.append(res[bf.nextInt() - 1]).append("\n");
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
