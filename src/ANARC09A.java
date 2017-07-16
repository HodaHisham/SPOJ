import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class ANARC09A {
 
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int k = 1;
	StringBuilder sb = new StringBuilder();
	while(true)
	{
	    String st = bf.next();
	    if(st.charAt(0) == '-')
		break;
	    int op = 0, ans = 0;
	    char [] c = st.toCharArray();
	    for (int i = 0; i < c.length; i++)
	    {
		if(c[i] == '{')
		    op++;
		else
		{
		    if(op == 0)
		    {
			ans++; op++;
		    }
		    else op--;
		}
	    }
	    ans += op/2;
	    sb.append(String.format("%d. %d\n", k++,ans));
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