//package CF;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class KGSS {
 
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	int N = 1; while(N < n) N <<= 1; 
	int[] in = new int[N + 1];
	for(int i = 1; i <= n; i++)
	    in[i] = bf.nextInt();
	SegmentTree sg = new SegmentTree(in);
	int q = bf.nextInt();
	//	out.println(Arrays.toString(sg.sTree));
	for (int i = 0; i < q; i++)
	{
	    int tmp = bf.next().charAt(0), x = bf.nextInt(), y = bf.nextInt();
	    if(tmp == 'Q'){
		Pair ans = sg.query(x, y);
		out.println(ans.max + ans.max2);
	    }
	    else sg.update_point(x,y);
	}
	out.flush();
	out.close();
    }
    static class Pair {
	int max;
	int max2;
	public Pair(int a,int b){
	    max = a;
	    max2 = b;
	}
	public String toString(){
	    return max + " " + max2;
	}
    }
    static class SegmentTree {		
 
	int N; 			
	int[] array;
	Pair [] sTree;
 
	SegmentTree(int[] in)		
	{
	    array = in; N = in.length - 1;
	    sTree = new Pair[N<<1];		
	    build(1,1,N);
	}
 
	void build(int node, int b, int e)	
	{
	    if(b == e)					
		sTree[node] = new Pair(array[b],0);
	    else						
	    {
		build(node<<1,b,(b+e)/2);
		build((node<<1)+1,(b+e)/2+1,e);
		Pair q1 = sTree[node<<1];
		Pair q2 = sTree[(node<<1)+1];
		Integer [] tmp = {q1.max,q1.max2,q2.max,q2.max2};
		Arrays.sort(tmp);
		sTree[node] = new Pair(tmp[3],tmp[2]);
	    }
	}
	void update_point(int index, int val)			// O(log n)
	{
	    index += N - 1;				
	    sTree[index] = new Pair(val, 0);			
	    while(index>1)				
	    {
		index >>= 1;
		Pair q1 = sTree[index<<1];
		Pair q2 = sTree[(index<<1)+1];
		Integer [] tmp = {q1.max,q1.max2,q2.max,q2.max2};
		Arrays.sort(tmp);
		sTree[index] = new Pair(tmp[3],tmp[2]);
	    }
	}
	Pair query(int i, int j)
	{
	    return query(1,1,N,i,j);
	}
 
	Pair query(int node, int b, int e, int i, int j)	
	{
	    if(i>e || j <b){
		return new Pair(0,0);		
	    }
	    if(b>= i && e <= j)
		return sTree[node];
	    Pair q1 = query(node<<1,b,(b+e)/2,i,j);
	    Pair q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
	    Integer [] tmp = {q1.max,q1.max2,q2.max,q2.max2};
	    Arrays.sort(tmp);
	    return new Pair(tmp[3],tmp[2]);
	}
 
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;
 
	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
 
	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}
 
	public int nextInt() throws IOException {return Integer.parseInt(next());}
 
	public long nextLong() throws IOException {return Long.parseLong(next());}
 
	public String nextLine() throws IOException {return br.readLine();}
 
	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}
 
	public boolean ready() throws IOException {return br.ready();}
    }
 
} 