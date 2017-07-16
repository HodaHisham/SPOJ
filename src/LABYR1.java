//package con11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
 
public class LABYR1 {
    static char [][] grid;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int n,m;
    static int [][] dist;
    public static boolean isValid(int x , int y){
	return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.';
    }
    static void bfs(int x, int y)
    {
	Queue<Pair> q = new LinkedList<Pair>();
	dist = new int[n][m];
	for (int i = 0; i < dist.length; i++)
	{
	    Arrays.fill(dist[i], -1);
	}
	q.add(new Pair(x,y));
	dist[x][y] = 0;
	while(!q.isEmpty())
	{
	    Pair u = q.remove();
 
	    for (int i = 0; i < dx.length; i++)
	    {
		
		if(isValid(u.x+dx[i], u.y+dy[i]) && dist[u.x+dx[i]][u.y+dy[i]] == -1)
		{
		    dist[u.x+dx[i]][u.y+dy[i]] = dist[u.x][u.y]+1;
		    q.add(new Pair(u.x+dx[i],u.y+dy[i]));
		}
	    }
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    m = bf.nextInt(); n = bf.nextInt();
	    grid = new char[n][m];
	    for (int i = 0; i < n; i++)
		grid[i] = bf.next().toCharArray();
	    loop:
		for (int i = 0; i < n; i++)
		{
		    for (int j = 0; j < m; j++)
		    {
			if(grid[i][j] == '.'){
			    bfs(i,j);
			    break loop;
			}
		    }
		}
	    int x = 0, y = 0;
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < m; j++)
		{
		    if(dist[i][j] > dist[x][y]){x = i; y = j;}
		}
	    }
	    bfs(x,y);
	     x = 0; y = 0;
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < m; j++)
		{
		    if(dist[i][j] > dist[x][y]){x = i; y = j;}
		}
	    }
	    out.println("Maximum rope length is "+dist[x][y]+".");
 
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int x; int y;
	public Pair(int x, int y){
	    this.x = x;
	    this.y = y;
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
	    while (st == null || !st.hasMoreTokens()){
		st = new StringTokenizer(br.readLine());
	    }
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
 