import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class NDIV {
    static ArrayList<Integer> primes;
    static int n;
    static int numDiv(int N)
    {
	int PF_idx = 0, PF = primes.get(PF_idx); int ans = 1; // start from ans = 1 
	while (1L*PF * PF <= N) {
	    long power = 0; // count the power 
	    while (N % PF == 0) { N /= PF; power++; }
	    ans *= (power + 1);
	    if(ans > n)
		return ans;
	    PF = primes.get(++PF_idx); 
	}
	if (N != 1) ans *= 2;
	return ans; 
    }
 
    static boolean [] prime;
    public static void main(String[] args) throws NumberFormatException, IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int a = bf.nextInt(), b = bf.nextInt(); n = bf.nextInt();
	primes = new ArrayList<Integer>();
	prime = new boolean[(int)1e6+1];
	Arrays.fill(prime, true);
	prime[0] = prime[1] = false;
	for (int i = 2; i < prime.length; i++)
	{
	    if(prime[i]){
		primes.add(i);
		if(1L*i*i < prime.length)
		for (int j = i*i; j < prime.length; j+=i)
		{
		    prime[j] = false;
		}
	    }
	}
	int res = 0;
	for (int i = a; i <= b; i++)
	{
	    res += (numDiv(i) == n)?1:0;
	}
	out.println(res);
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
 