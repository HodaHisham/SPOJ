import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AE00 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int[] val = new int[10001];
		for (int i = 1; i * i < val.length; i++)
			for (int j = i; i * j < val.length; j++)
				val[i * j]++;
		for (int i = 1; i < val.length; i++)
			val[i] += val[i - 1];
		out.println(val[bf.nextInt()]);
		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream b) {
			br = new BufferedReader(new InputStreamReader(b));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
