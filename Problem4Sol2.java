import java.io.*;
import java.util.*;

public class Problem4Sol2
{
	Node[] nodes;
	PriorityQueue<Party> q = new PriorityQueue<Party>();
	
	class Node
	{
		int cost;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		//int min = Integer.MAX_VALUE;
		int most = -1;
		
		Node(int cost)
		{
			this.cost = cost;
		}
		
		/*void addEdge(int cost, int end)
		{
			min = Math.min(min, cost);
			edges.add(new Edge(cost,end));
		}*/
	}
	
	class Edge
	{
		int cost;
		int end;
		
		Edge(int cost, int end)
		{
			this.cost = cost;
			this.end = end;
		}
	}
	
	class Party implements Comparable<Party>
	{
		int index;
		int cost;
		int count;
		int last;
		
		Party(int i, int c, int count, int last)
		{
			this.index = i;
			this.cost = c;
			this.count = count;
			this.last = last;
		}
		
		@Override
		public int compareTo(Party o)
		{
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public int pathfind(int x)
	{
		q.add(new Party(0,0,0,0));
		q.add(new Party(0,nodes[0].cost,1,-1));
		
		while (true)
		{
			Party party = q.poll();
			if(party.count>nodes[party.index].most)
			{
			nodes[party.index].most = party.count;
			
			if (party.count == x)
			{
				if(party.index == 0)
				{
					q.clear();
					return party.cost;
				}
				else
				{
					for(Edge e : nodes[party.index].edges)
					{
						if(e.end!=party.last)
						{
							q.add(new Party(e.end,party.cost+e.cost,party.count,party.index));
						}
					}
				}
			}
			else
			{
				//System.out.println(party.index);
				for(Edge e : nodes[party.index].edges)
				{
					if(e.end!=party.last)
					{
						//if(party.count>nodes[e.end].most)
						//{
							q.add(new Party(e.end,party.cost+e.cost,party.count,party.index));
						//}
					}
					//if(party.count+1>nodes[e.end].most)
					//{
						q.add(new Party(e.end,party.cost+e.cost+nodes[e.end].cost,party.count+1,-1));
					//}
				}
			}
			}
		}

	}

	public static void main(String[] args)
	{
		Problem4Sol2 p = new Problem4Sol2();
		String fileLocation = System.getProperty("user.dir");
		fileLocation += "/" + "input2" + ".txt";
		
		BufferedReader br = null;
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter("output",true));
			br = new BufferedReader(new FileReader(fileLocation));
		} catch ( IOException e)
		{
			e.printStackTrace();
		}
		String l = null;
		String[] ls = null;
		int T = 0;
		int n = 0;
		int m = 0;
		int x = 0;
		try
		{
			l = br.readLine();
			T = Integer.parseInt(l);
			
			for(int j = 0;j<T;j++)
			{
				l = br.readLine();
				ls = l.split(" ");
				n = Integer.parseInt(ls[0]);
				m = Integer.parseInt(ls[1]);
				x = Integer.parseInt(ls[2]);
				p.nodes = new Node[n];
				
				//System.out.println("j is "+j);
				
				l = br.readLine();
				ls = l.split(" ");
				for (int i = 0; i < n; i++)
				{
					p.nodes[i] = p.new Node(Integer.parseInt(ls[i]));
				}
				
				for (int i = 0; i < m; i++)
				{
					l = br.readLine();
					ls = l.split(" ");
					int i1 = Integer.parseInt(ls[0]);
					int i2 = Integer.parseInt(ls[1]);
					int cost = Integer.parseInt(ls[2]);
					
					p.nodes[i1].edges.add(p.new Edge(cost,i2));
					p.nodes[i2].edges.add(p.new Edge(cost,i1));
					
				}
				/*int index = 0;
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++)
				{
					int newMin = p.nodes[i].cost+p.nodes[i].min*2;
					if(min>newMin)
					{
						min = newMin;
						index = i;
					}
				}*/
				
				
				int result = p.pathfind(x);
				System.out.println(result);
				writer.append("Case #"+(j+1)+": "+result+"\n");
				
			}
			
			writer.close();
			

		} catch (IOException e)
		{
		}

	}

}