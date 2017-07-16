import java.io.*;
import java.util.*;
class Main{
    static int [] dis;
    static ArrayList<Integer> a[];
    public static void main(String[]args)throws java.lang.Exception{
	BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	dis = new int[n];
	a = new ArrayList[n];
	Arrays.fill(dis,-1);
	for(int i = 0 ;i<n;i++)
	    a[i] = new ArrayList<Integer>();
	for(int i = 0;i < n-1;i++){
	    st = new StringTokenizer(bf.readLine());
	    int node = Integer.parseInt(st.nextToken());
	    int node2 = Integer.parseInt(st.nextToken());
	    a[node-1].add(node2-1);
	    a[node2-1].add(node-1);
	}
	bfs(0);
	int max = -1;
	int index = -1;
	for(int i = 0; i<n;i++){
	    if(dis[i]>max){
		max = dis[i];
		index = i;
	    }
	}
	bfs(index);
	max = -1;

	for(int i = 0; i<n;i++){
	    if(dis[i]>max){
		max = dis[i];

	    }
	}
	System.out.println(max);
    }
    public static void bfs(int src){
	Queue <Integer> q = new LinkedList<Integer>();
	Arrays.fill(dis,-1);
	q.add(src);
	dis[src] = 0;
	while(!q.isEmpty()){
	    int u = q.poll();
	    for(int i = 0; i<a[u].size();i++){
		int v = a[u].get(i);
		if(dis[v] == -1){
		    dis[v] = dis[u]+1;
		    q.add(v);
		}
	    }
	}
    }

} 