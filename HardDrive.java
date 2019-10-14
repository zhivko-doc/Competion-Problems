import java.io.*;

public class HardDrive
{
	public static void main(String[] args)
	{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = null;
		String[] ls = null;
		int n = 0;
		int[] array = null;
		try
		{
			l = br.readLine();
			ls = l.split(" ");
			n = Integer.parseInt(ls[0]);
			
			l = br.readLine();
			ls = l.split(" ");
			for (int i = 0; i < ; i++)
			{
				
			}

		} catch (IOException e)
		{
		}*/
		
		
		/*
		 * 
		String l = null;
		String[] ls = null;
		int n = 0;
		int[] array = null;
		
		String fileLocation = System.getProperty("user.dir");
		fileLocation += "/" + "input1" + ".txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("output",true));
		 */
		
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = null;
		String[] ls = null;
		int n = 0;
		int maxChanges = 0;
		int broken = 0;
		int[] drive = null;
		int curChanges = 0;
		try
		{
			l = br.readLine();
			ls = l.split(" ");
			n = Integer.parseInt(ls[0]);
			drive = new int[n];
			maxChanges = Integer.parseInt(ls[1]);
			broken = Integer.parseInt(ls[2]);
			l = br.readLine();
			ls = l.split(" ");
			for (int i = 0; i < broken - 1; i++)
			{
				drive[Integer.parseInt(ls[i]) - 1] = 2;
			}
			drive[n - 1] = 2;

		} catch (IOException e)
		{
		}

		if (maxChanges % 2 != 0)
		{
			drive[0] = 1;
			curChanges++;
		}

		for (int i = 1; i < n; i++)
		{
			if (curChanges == maxChanges)
			{
				for (int j = i; j < n; j++)
				{
					if (drive[j] == 2)
					{
						drive[j] = 0;
					}
				}
				break;
			}
			else
			{
				if (drive[i] == 2)
				{
					drive[i] = 0;
				}
				else
				{
					if (drive[i - 1] == 1)
					{
					}
					else
					{
						drive[i] = 1;
						curChanges += 2;
					}
				}
			}
		}
		printArr(drive);
	}

	public static void printArr(int[] arr)
	{
		int l = arr.length;
		StringBuffer s = new StringBuffer(l);

		for (int i = 0; i < l; i++)
			s.append(arr[i]);
		System.out.println(s);
	}

}
