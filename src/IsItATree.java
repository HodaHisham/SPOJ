
import java.io.*;
import java.util.*;

public class IsItATree {
	static boolean[] vis;
	static ArrayList<Integer> a[];

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		vis = new boolean[n];
		a = new ArrayList[n];
		Arrays.fill(vis, false);

		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
			// a[i].add(i+1);setting up the arraylist
		}
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(bf.readLine());
			int node = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			a[node - 1].add(node2 - 1);
			a[node2 - 1].add(node - 1);
		}
		// building up the arrylist
		if (n - 1 == m) {
			dfs(0);
			boolean flag = false;
			for (int i = 0; i < n; i++)
				if (!vis[i]) {
					flag = true;
					break;
				}
			if (flag)
				System.out.print("NO");
			else
				System.out.print("YES");

		} else
			System.out.println("NO");
	}

	public static void dfs(int nod) {
		if (vis[nod])
			return;
		vis[nod] = true;
		for (int i = 0; i < a[nod].size(); i++) {
			int dest = a[nod].get(i);
			dfs(dest);
		}

	}
}