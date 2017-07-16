import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ABSYS {

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		for (int k = 1; k <= 10; k++) {
			int n = bf.nextInt();
			char[] s = bf.nextLine().toCharArray();
			int q = bf.nextInt();
			int N = 1;
			while (N < n)
				N <<= 1;
			int[] in = new int[N + 1];
			for (int i = 1; i <= n; i++)
				in[i] = s[i - 1] == '(' ? -1 : 1;

			SegmentTree sg = new SegmentTree(in);
			out.println("Test " + k + ":");
			for (int i = 0; i < q; i++) {
				int tmp = bf.nextInt();
				if (tmp == 0)
					out.println(sg.sTree[1].open == sg.sTree[1].close && sg.sTree[1].close == 0 ? "YES" : "NO");
				else
					sg.update_point(tmp);
			}
		}
		out.flush();
		out.close();
	}

	static class Pair {
		int open;
		int close;

		public Pair(int a, int b) {
			open = a;
			close = b;
		}

		public String toString() {
			return open + " " + close;
		}
	}

	static class SegmentTree {

		int N;
		int[] array;
		Pair[] sTree;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new Pair[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) {
			if (b == e)
				sTree[node] = new Pair(array[b] == -1 ? 1 : 0, array[b] == 1 ? 1 : 0);
			else {
				build(node << 1, b, (b + e) / 2);
				build((node << 1) + 1, (b + e) / 2 + 1, e);
				Pair q1 = sTree[node << 1];
				Pair q2 = sTree[(node << 1) + 1];
				int min = Math.min(q1.open, q2.close);
				sTree[node] = new Pair(q1.open + q2.open - min, q1.close + q2.close - min);
			}
		}

		void update_point(int index) // O(log n)
		{
			index += N - 1;
			sTree[index] = new Pair(1 - sTree[index].open, 1 - sTree[index].close);
			while (index > 1) {
				index >>= 1;
				Pair q1 = sTree[index << 1];
				Pair q2 = sTree[(index << 1) + 1];
				int min = Math.min(q1.open, q2.close);
				sTree[index] = new Pair(q1.open + q2.open - min, q1.close + q2.close - min);
			}
		}

		Pair query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		Pair query(int node, int b, int e, int i, int j) {
			if (i > e || j < b) {
				return new Pair(0, 0);
			}
			if (b >= i && e <= j)
				return sTree[node];
			Pair q1 = query(node << 1, b, (b + e) / 2, i, j);
			Pair q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			int min = Math.min(q1.open, q2.close);
			return new Pair(q1.open + q2.open - min, q1.close + q2.close - min);
		}

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

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}