
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class POSTERS {
	static HashSet<Integer> ans;

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			int n = bf.nextInt();
			int[] l = new int[n];
			int[] r = new int[n];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			TreeSet<Integer> set = new TreeSet<Integer>();
			int count = 1;
			for (int i = 0; i < n; i++) {
				int lt = bf.nextInt(), rt = bf.nextInt();
				set.add(lt);
				set.add(rt);
				l[i] = lt;
				r[i] = rt;
			}
			for (int i : set) {
				map.put(i, count++);
			}
			count--;
			int tmp = 1;
			while (tmp < count)
				tmp <<= 1;
			SegmentTree sg = new SegmentTree(tmp);
			for (int i = 0; i < r.length; i++) {
				sg.update_range(map.get(l[i]), map.get(r[i]), i + 1);
				// System.out.println(Arrays.toString(sg.lazy));
			}
			ans = new HashSet<Integer>();
			sg.query(1, count);
			out.println(ans.size());
		}
		out.flush();
		out.close();
	}

	static class SegmentTree { // 1-based DS, OOP

		int N; // the number of elements in the array as a power of 2 (i.e.
				// after padding)
		int[] sTree, lazy;

		SegmentTree(int n) {
			N = n;
			sTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to
										// cross out index zero
			lazy = new int[N << 1];
		}

		void update_range(int i, int j, int val) // O(log n)
		{
			update_range(1, 1, N, i, j, val);
		}

		void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				lazy[node] = val;
				return;
			} else {
				int mid = b + e >> 1;
				propagate(node, b, mid, e);
				update_range(node << 1, b, mid, i, j, val);
				update_range(node << 1 | 1, mid + 1, e, i, j, val);
			}

		}

		void propagate(int node, int b, int mid, int e) {
			if (lazy[node] != 0)
				lazy[node << 1] = lazy[node << 1 | 1] = lazy[node];
			lazy[node] = 0;
		}

		void query(int i, int j) {
			query(1, 1, N, i, j);
		}

		void query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return;
			if (lazy[node] != 0) {
				ans.add(lazy[node]);
				return;
			}
			if (b == e)
				return;
			int mid = b + e >> 1;
			query(node << 1, b, mid, i, j);
			query(node << 1 | 1, mid + 1, e, i, j);
		}
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