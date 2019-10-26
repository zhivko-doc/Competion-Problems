import java.io.*;

public class BreakingBranches {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		try {
			n = Integer.parseInt(br.readLine());
			
			if(n%2==0)
			{
				System.out.println("Alice");
				System.out.println(1);
			}
			else
			{
				System.out.println("Bob");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
