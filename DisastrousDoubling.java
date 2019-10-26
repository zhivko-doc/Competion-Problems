import java.io.*;
import java.math.BigInteger;

public class DisastrousDoubling {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = null;
		String[] ls = null;
		int n = 0;
		BigInteger b = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		try {
			l = br.readLine();
			n = Integer.parseInt(l);
			l = br.readLine();
			ls = l.split(" ");
			for(int i = 0;i<n;i++)
			{
				BigInteger curr = new BigInteger(ls[i]);
				b = b.multiply(two);
				if(b.compareTo(curr) == -1)
				{
					System.out.println("error");
					return;
				}
				
				b = b.subtract(curr);
			}
		} catch (IOException e) {
		}
		
		System.out.println(b.mod(new BigInteger("1000000007")));
	}

}
