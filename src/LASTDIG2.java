import java.math.BigInteger;
import java.util.Scanner;

public class LASTDIG2 {
	static int modPow(int a, int e, int mod) // O(log e)
	{
		a %= mod;
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		int tc = bf.nextInt();
		while (tc-- > 0) {
			BigInteger a = bf.nextBigInteger();
			long b = bf.nextLong();
			if (b == 0) {
				System.out.println(1);
			} else {
				if (b % 4 == 0)
					b = 4;
				else
					b %= 4;
				System.out.println(modPow(a.mod(BigInteger.valueOf(10)).intValue(), (int) b, 10));
			}
		}
	}
}