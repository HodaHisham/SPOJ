import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LITE {

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = bf.nextInt(), q = bf.nextInt();
		int N = 1;
		while (N < n)
			N <<= 1;
		int[] in = new int[N + 1];
		SegmentTree sg = new SegmentTree(in);
		for (int i = 0; i < q; i++) {
			int tmp = bf.nextInt(), x = bf.nextInt(), y = bf.nextInt();
			if (tmp == 1) {
				out.println(sg.query(x, y));
			} else
				sg.update_range(x, y);
		}
		out.flush();
		out.close();
	}

	static class SegmentTree { // 1-based DS, OOP

		int N; 
		int[] array, sTree, lazy;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new int[N << 1];
			lazy = new int[N << 1];
		}

		void update_range(int i, int j) // O(log n)
		{
			update_range(1, 1, N, i, j);
		}

		void update_range(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				sTree[node] = (e - b + 1) - sTree[node];
				lazy[node] = (lazy[node] + 1) % 2;
			} else {
				int mid = b + e >> 1;
				propagate(node, b, mid, e);
				update_range(node << 1, b, mid, i, j);
				update_range(node << 1 | 1, mid + 1, e, i, j);
				sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
			}
		}

		void propagate(int node, int b, int mid, int e) {
			if (lazy[node] != 0) {
				lazy[node << 1] = (lazy[node] + lazy[node << 1]) % 2;
				lazy[node << 1 | 1] = (lazy[node] + lazy[node << 1 | 1]) % 2;
				sTree[node << 1] = (mid - b + 1) - sTree[node << 1];
				sTree[node << 1 | 1] = (e - mid) - sTree[node << 1 | 1];
			}
			lazy[node] = 0;
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		int query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return sTree[node];
			int mid = b + e >> 1;
			propagate(node, b, mid, e);
			int q1 = query(node << 1, b, mid, i, j);
			int q2 = query(node << 1 | 1, mid + 1, e, i, j);
			return q1 + q2;
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