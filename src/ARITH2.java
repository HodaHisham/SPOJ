import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ARITH2 {
	
	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			Queue<String> q = new LinkedList<>();
			while (true) {
				String s = bf.next();
				if (s.equals("="))
					break;
				q.add(s);
			}
			long res = 0;
			if (!q.isEmpty())
				res = Long.parseLong(q.poll());
			while (!q.isEmpty()) {
				String op = q.poll();
				long n = Long.parseLong(q.poll());
				switch (op) {
				case "+":
					res += n;
					break;
				case "-":
					res -= n;
					break;
				case "*":
					res *= n;
					break;
				case "/":
					res /= n;
					break;
				default:
					break;
				}
			}
			out.println(res);
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