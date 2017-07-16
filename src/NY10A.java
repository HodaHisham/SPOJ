import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NY10A {
	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tc = bf.nextInt();
		while (tc-- > 0) {
			int n = bf.nextInt();
			int[] p = new int[8];
			char[] c = bf.next().toCharArray();
			int tmp = 0;
			if (c[0] == 'H')
				tmp = 100;
			if (c[1] == 'H')
				tmp += 10;
			if (c[2] == 'H')
				tmp++;
			p[Integer.parseInt("" + tmp, 2)]++;
			for (int i = 3; i < c.length; i++) {
				tmp %= 100;
				tmp *= 10;
				tmp += c[i] == 'H' ? 1 : 0;
				p[Integer.parseInt("" + tmp, 2)]++;
			}
			out.print(n);
			for (int i = 0; i < p.length; i++) {
				out.print(" " + p[i]);
			}
			out.println();
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