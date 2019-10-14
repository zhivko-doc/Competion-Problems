import java.io.*;
import java.util.*;

public class Dugovi
{
	int n;
	Person[] ppl;

	class Person
	{
		int money = 0;
		int owes;
		int end;
		int incoming = 0;

		boolean paid = false;

	}

	void solve()
	{
		int sum = 0;
		Stack<Integer> q = new Stack<>();
		for (int i = 0; i < n; i++)
		{
			if (ppl[i].incoming == 0)
			{
				q.add(i);
			}
		}

		while (!q.isEmpty())
		{
			int curr = q.pop();

			if (ppl[curr].money < ppl[curr].owes)
			{
				// System.out.println("sum "+sum);
				sum += ppl[curr].owes - ppl[curr].money;
			}
			ppl[curr].paid = true;
			ppl[ppl[curr].end].money += ppl[curr].owes;

			if (!ppl[ppl[curr].end].paid && (--ppl[ppl[curr].end].incoming == 0 || ppl[ppl[curr].end].money >= ppl[ppl[curr].end].owes))
			{
				// System.out.println(ppl[curr].end);
				q.add(ppl[curr].end);
			}
			/*
			 * else if(ppl[ppl[curr].end].money>=ppl[ppl[curr].end].owes&&!ppl[ppl[curr].end].paid) {
			 * q.add(ppl[curr].end); }
			 */
		}
		
		//System.out.println("sum at first + "+sum);

		for (int i = 0; i < n; i++)
		{
			if (!ppl[i].paid)
			{
				/*
				 * int min = ppl[i].owes-ppl[i].money; if(min<0) { min = 0; }
				 */

				int min = Integer.MAX_VALUE;
				int cur = i;
				int next = ppl[i].end;
				//ppl[cur].paid = true;

				while (true)
				{
					min = Math.min(min, ppl[cur].owes - ppl[cur].money);
					//System.out.println("min is "+min+" "+ sum);
					if (ppl[cur].owes + ppl[next].money < ppl[next].owes)
					{
						//System.out.println("cur is "+cur+" next is "+next+" adding "+(ppl[next].owes-(ppl[cur].owes + ppl[next].money)));
						sum += ppl[next].owes-(ppl[cur].owes + ppl[next].money);
						//System.out.println("sum is "+sum);
					}
					cur = next;
					next = ppl[cur].end;

					ppl[cur].paid = true;
					if (cur == i)
					{
						break;
					}
				}
				if(min<0)
				{
					min = 0;
				}
				sum+=min;
			}
		}

		System.out.println(sum);

	}

	public static void main(String[] args)
	{
		Dugovi d = new Dugovi();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = null;
		String[] ls = null;
		try
		{
			l = br.readLine();
			d.n = Integer.parseInt(l);
			d.ppl = new Person[d.n];

			for (int i = 0; i < d.n; i++)
			{
				d.ppl[i] = d.new Person();
			}

			for (int i = 0; i < d.n; i++)
			{
				l = br.readLine();
				ls = l.split(" ");

				int end = Integer.parseInt(ls[0]) - 1;

				d.ppl[i].end = end;
				d.ppl[i].owes = Integer.parseInt(ls[1]);
				d.ppl[end].incoming++;

			}

		} catch (IOException e)
		{
		}

		d.solve();
	}

}
