import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class COINS {
    static HashMap<Integer, Long> memo;
    public static long dp(int n){
	if(n == 0)
	    return 0;
	if(memo.containsKey(n))
	    return memo.get(n);
	long ans = Math.max(n,dp(n/2)+dp(n/3)+dp(n/4));
	memo.put(n, ans);
	return ans;
    }
    public static void main(String [] args) throws NumberFormatException, IOException {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new HashMap<Integer,Long>();
	while(bf.ready()){
	    int n = bf.nextInt();
	    out.println(dp(n));
	}
	out.flush();
	out.close();
    }
 
    static class Scanner{
	BufferedReader br;
	StringTokenizer st;
	public Scanner(InputStream b){
	    br = new BufferedReader(new InputStreamReader(b));
	}
	public String next() throws IOException{
	    while(st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}
	public int nextInt() throws NumberFormatException, IOException{
	    return Integer.parseInt(next());
	}
	public String nextLine() throws IOException{
	    return br.readLine();
	}
	public boolean ready() throws IOException{
	    return br.ready();
	}
    }
}
 