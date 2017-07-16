import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class PIGBANK {
 
    static int [][] memo;
    static Pair [] coins;
    static int w;
    static int INF = (int)1e9;
    public static int min(int weight, int ind){
	if(weight == w)
	    return 0;
	if(ind == coins.length)
	    return INF;
	if(memo[weight][ind] != -1)
	    return memo[weight][ind];
	int ans = INF;
	if(coins[ind].w + weight <= w){
	    ans = Math.min(ans, coins[ind].p + min(weight+coins[ind].w,ind));
	    ans = Math.min(ans, coins[ind].p + min(weight+coins[ind].w,ind+1));
	}
	ans = Math.min(ans, min(weight,ind+1));
	return memo[weight][ind] = ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-- > 0){
	    w = bf.nextInt(); w = bf.nextInt()-w;
	    int m = bf.nextInt();
	    coins = new Pair[m];
	    for (int i = 0; i < m; i++){
		coins[i] = new Pair(bf.nextInt(),bf.nextInt());
	    }
	    memo = new int[10001][m+1];
	    for (int i = 0; i < memo.length; i++)
		Arrays.fill(memo[i], -1);
	    int ans = min(0,0);
	    out.println(ans >= INF?"This is impossible.":"The minimum amount of money in the piggy-bank is "+ ans +".");
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int w; int p;
	public Pair(int price, int weight){
	    p = price;
	    w = weight;
	}
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
 