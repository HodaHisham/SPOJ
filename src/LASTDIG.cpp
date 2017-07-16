#include<cmath>
#include<iostream>
using namespace std;
int main() {
	int t, a, b;
	cin >> t;
	while (t-- > 0) {
		cin >> a >> b;
		if (b == 0) {
			cout << 1 << '\n';
		} else {
			if (b % 4 == 0)
				b = 4;
			else
				b %= 4;
			int out = (int) (pow(a % 10, b)) % 10;
			cout << out << '\n';

		}
	}
	return 0;
}
