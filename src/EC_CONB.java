import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class EC_CONB {
 
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	StringBuilder sb = new StringBuilder();
	while(n-->0)
	{
	    int a = bf.nextInt();
	    if(a % 2 == 0)
	    {
		int sz = 1;
		while((1<<sz) <= a) sz++;
		for (int i = 0, j = sz-1; i < sz/2; i++, j--)
		{
		    int t = ((a & (1<<i)) == 0?0:1)^((a & (1<<j)) == 0?0:1);
		    a ^= (t<<i);
		    a ^= (t<<j);
		}
	    }
	    sb.append(a).append("\n");
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