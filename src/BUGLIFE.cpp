#include <cstdio>
#include <deque>
#include <iostream>
#include <utility>
#include <vector>

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<char, int> ii;
typedef vector<ii> vii;
typedef vector<int> vi;

#define INF 1000000000
#define EPS 1e-9
#define endl "\n"
#define make_cin_fast std::ios_base::sync_with_stdio(false);cin.tie(0);
#define clr(ma) memset(ma,-1,sizeof ma)
#define clean(vis)  memset(vis,0,sizeof vis)
#define INC(i,a,b) for(int i = a; i < b; ++i)
#define DEC(i,a,b) for(int i = a; i >= b; --i)
int max(int x, int y) {
	return x >= y ? x : y;
}
int min(int x, int y) {
	return x >= y ? y : x;
}
int q, n, c, u, v;
int adjList[2500][2500];
int vis[2500];
bool dfs(int u) {
	for (int v = 0; v < c; v++)
		if (adjList[u][v] == 1) {
			if (vis[v] == -1) {
				vis[v] = 1 ^ vis[u];
				if (!dfs(v))
					return false;
			} else if (vis[u] == vis[v])
				return false;
		}
	return true;
}

int mod = 1000000007;

int main() {
	make_cin_fast;
	cin >> q;
	for(int t = 1; t <= q;t++) {
		cin>>c>>n;
		for(int j = 0; j < c; j++)
		clean(adjList[j]);
		while(n-->0) {
			cin>>u>>v;
			u--; v--;
			adjList[u][v] = 1;
			adjList[v][u] = 1;
		}
		bool f = true;
		clr(vis);
		for(int i = 0; i < c; i++) {
			if(vis[i] == -1) {
				vis[i] = 0;
				f &= dfs(i);
			}
		}
		cout << "Scenario #"<<t<<":"<<endl;
		if(f) cout<<"No suspicious bugs found!"<<endl;
		else cout << "Suspicious bugs found!"<<endl;
	}
}
