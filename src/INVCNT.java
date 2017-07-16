import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class INVCNT {
	static long mergeSort(int[] a, int b, int e) {
		long res = 0;
		if (b < e) {
			int mid = (b + e) / 2;
			res += mergeSort(a, b, mid);
			res += mergeSort(a, mid + 1, e);
			res += merge(a, b, mid, e);
		}
		return res;
	}

	static final int INF = (int) 1e9;

	static long merge(int[] a, int b, int mid, int e) {
		long res = 0;
		int n1 = mid - b + 1;
		int n2 = e - mid;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			L[i] = a[b + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = a[mid + i + 1];
		}
		L[n1] = R[n2] = INF;
		for (int k = b, i = 0, j = 0; k <= e; k++) {
			if (L[i] <= R[j])
				a[k] = L[i++];
			else {
				res += n1 - i;
				a[k] = R[j++];
			}
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			int n = bf.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = bf.nextInt();
			}
			out.println(mergeSort(a, 0, n - 1));
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
