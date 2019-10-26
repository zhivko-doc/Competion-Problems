import java.io.*;
import java.math.*;

public class Gamesmanship {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String l = null;
		double n = 0;
		
		try {
			n = Double.parseDouble(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal bg = new BigDecimal(Math.tan(Math.toRadians(n))*10);
		System.out.println(bg.setScale(10,RoundingMode.HALF_UP ));

	}

}
