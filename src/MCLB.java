import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
 
public class MCLB {
    public static void main(String[] args) throws NumberFormatException, IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	StringBuilder sb = new StringBuilder();
	for(int c = 1; c <= TC; c++){
	    char [] s = bf.next().toCharArray();
	    char [] t = bf.next().toCharArray();
	    StringBuilder tmp = new StringBuilder();
	    for (int i = 0; i < s.length; i++)
	    {
		tmp.append(s[i]=='R'?0:1);
	    }
	    BigInteger a = new BigInteger(tmp.toString(),2);
	    tmp = new StringBuilder();
	    for (int i = 0; i < t.length; i++)
	    {
		tmp.append(t[i]=='R'?0:1);
	    }
	    BigInteger b = new BigInteger(tmp.toString(),2);
	    sb.append("Case ").append(c);
	    if(b.compareTo(a) >= 0 && a.compareTo(BigInteger.ZERO) != 0){
		sb.append(": The goal state could be reached after ").append(b.subtract(a).toString()).append(" laser beams.\n");
	    }
	    else sb.append(": The goal state will never be reached!\n");
 
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