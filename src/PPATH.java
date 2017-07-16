import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class PPATH{
    static boolean [] prime;
    public static void main(String[] args) throws NumberFormatException, IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	ArrayList<Integer> primes = new ArrayList<Integer>();
	prime = new boolean[(int)1e4];
	int n = prime.length;
	Arrays.fill(prime, true);
	prime[0] = prime[1] = false;
	for (int i = 2; i < n; i++)
	{
	    if(prime[i]){
		primes.add(i);
		if(1L*i*i < n)
		    for (int j = i*i; j < n; j+=i)
		    {
			prime[j] = false;
		    }
	    }
	}
	ArrayList<Integer> [] adjList = new ArrayList[n];
	for (int i = 0; i < n; i++)
	{
	    adjList[i] = new ArrayList<>();
	}
	for (int i = 1000; i < n; i++)
	{
	    if(!prime[i]) continue;
	    StringBuilder sb = new StringBuilder(""+i);
	    for (int j = 0; j < 4; j++)
	    {
		for (int k = 0; k < 10; k++)
		{
		    if(j == 0 && k == 0) continue;
		    char tmp = sb.charAt(j);
		    if(tmp == k) continue;
		    sb.setCharAt(j, (char)('0'+k));
		    int p = Integer.parseInt(sb.toString());
		    if(prime[p])
			adjList[i].add(p);
		    sb.setCharAt(j, tmp);
 
		}
	    }
	}
	StringBuilder sb = new StringBuilder();
	while(TC-->0){
	    int a = bf.nextInt(), b = bf.nextInt();
	    int [] vis = new int[n];
	    Arrays.fill(vis, -1);
	    Queue<Integer> q = new LinkedList<>();
	    vis[a] = 0;
	    q.add(a);
	    while(!q.isEmpty())
	    {
		int u = q.remove();
		if(u == b)
		    break;
		for(int v:adjList[u])
		    if(vis[v] == -1){
			q.add(v);
			vis[v] = vis[u]+1;
		    }
	    }
	    sb.append(vis[b] == -1?"Impossible":vis[b]).append("\n");
	}
	out.print(sb);
	out.flush();
	out.close();
    }
 
    static class Scanner {
	StringTokenizer st;
	BufferedReader br;
 
	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}
 
	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);
	}
 
	public String next() throws IOException
	{
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}
 
	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}
 
	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}
 
	public String nextLine() throws IOException
	{
	    return br.readLine();
	}
 
	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}
 