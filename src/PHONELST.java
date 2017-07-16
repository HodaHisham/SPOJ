
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PHONELST {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int TC = bf.nextInt();
		while (TC-- > 0) {
			int n = bf.nextInt();
			boolean con = true;
			Trie t = new Trie();
			for (int i = 0; i < n; i++) {
				char[] c = bf.next().toCharArray();
				if (!t.search(c))
					con = false;
				t.put(c, i);
			}
			out.println(con ? "YES" : "NO");
		}
		out.print(sb);
		out.flush();
		out.close();
	}

	static class Trie {

		static final int R = 10;

		static class Node {
			Node[] next = new Node[R];
			int val = -1;
		}

		Node root = new Node();

		void put(char[] s, int idx) // O(n) where n = |s|. Can be implemented
									// recursively
		{
			Node cur = root;
			for (char c : s) {
				Node nxt = cur.next[c - '0'];
				if (nxt == null)
					nxt = cur.next[c - '0'] = new Node();
				cur = nxt;
			}
			cur.val = idx;
		}

		boolean search(char[] s) {
			Node cur = root;
			for (char c : s) {
				Node nxt = cur.next[c - '0'];
				if (nxt == null)
					return true;
				else if(nxt.val != -1)
					return false;
				cur = nxt;
			}
			return cur == null;
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