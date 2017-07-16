import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class ARMY {
    static class Pair implements  Comparable<Pair>{
	int num; int ind;
	public Pair(int n, int i){
	    num = n;
	    ind = i;
	}
	@Override
	public int compareTo(Pair o)
	{
	    // TODO Auto-generated method stub
	    if(num == o.num)
		return ind - o.ind;
	    return num - o.num;
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int a = bf.nextInt(), b = bf.nextInt();
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    for (int i = 0; i < a; i++)
	    {
		pq.add(new Pair(bf.nextInt(),1));
	    }
	    for (int i = 0; i < b; i++)
	    {
		pq.add(new Pair(bf.nextInt(), 0));
	    }
	    while(!pq.isEmpty() && a > 0 && b > 0){
		if(pq.peek().ind == 1)
		    a--;
		else
		    b--;
		pq.remove();
	    }
	    out.println(a==0&&b==0?"uncertain":a==0?"MechaGodzilla":"Godzilla");
	}
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