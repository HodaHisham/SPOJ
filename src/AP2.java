import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AP2 {
	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(bf.next());
		while (TC-- > 0) {
			long a3 = bf.nextLong(), b3 = bf.nextLong(), sum = bf.nextLong();
			long n = 2 * sum / (a3 + b3);
			sb.append(n).append("\n");
			long d = (b3 - a3) / (n - 5);
			long a1 = a3 - 2 * d;
			sb.append(a1);
			for (int i = 1; i < n; i++) {
				a1 += d;
				sb.append(" ").append(a1);
			}
			sb.append("\n");
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

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
