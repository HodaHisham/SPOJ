//package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EGYPIZZA {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt(), hv = 0, qtr = 0, qtr3 = 0;
	for (int i = 0; i < n; i++)
	{
	    char[] c = bf.next().toCharArray();
	    if(c[2] == '2') hv++;
	    else if(c[0] == '1') qtr++;
	    else qtr3++;
	}
	qtr -= qtr3;
	if(qtr < 0) qtr = 0;
	else if(qtr > 0)
	{
	    if(hv % 2 == 1)
		qtr -= 2;
	    qtr = Math.max(qtr, 0);
	    qtr = qtr/4 + (qtr % 4 != 0?1:0);
	}
	out.print(1+(hv/2+hv%2)+qtr3+qtr);
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