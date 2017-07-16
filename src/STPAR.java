import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class STPAR {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = bf.nextInt();
			if (n == 0)
				break;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				q.add(bf.nextInt());
			}
			Stack<Integer> st = new Stack<>();
			boolean flag = true;
			int idx = 1;
			while (!q.isEmpty() && flag) {
				int tmp = q.remove();
				if (tmp == idx) {
					idx++;
					continue;
				}
				while (!st.isEmpty() && st.peek() == idx) {
					idx++;
					st.pop();
				}
				st.add(tmp);
			}
			while (!st.isEmpty() && st.peek() == idx) {
				idx++;
				st.pop();
			}
			sb.append(st.isEmpty() ? "yes" : "no").append("\n");
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