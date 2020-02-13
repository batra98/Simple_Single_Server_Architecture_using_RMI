import java.util.*;


public class GraphMst extends java.rmi.server.UnicastRemoteObject implements Mst
{
	public static HashMap<String,Graph> graph_identifier = new HashMap<String,Graph>();

	public GraphMst()throws java.rmi.RemoteException
	{
		super();
	}

	// static class Edge
	// {
	// 	int from,to,weight;

	// 	Edge(int f,int t,int w)
	// 	{
	// 		from = f;
	// 		to = t;
	// 		weight = w;
	// 	}
	// }

	// static class Graph
	// {
	// 	int V;
	// 	ArrayList<ArrayList<Edge>> G;

	// 	Graph(int vertices)
	// 	{
	// 		V = vertices;
	// 		G = new ArrayList<>();

	// 		for(int i=0;i<vertices;i++)
	// 		{
	// 			G.add(new ArrayList<>());
	// 		}
	// 	}
	// }

	public void printGraph(Graph graph)throws java.rmi.RemoteException
	{
		int V = graph.V;

		for(int i=0;i<=V;i++)
		{
			System.out.print(i+"->");
			for(int j = 0;j<(graph.G.get(i).size());j++)
			{
				System.out.print(graph.G.get(i).get(j).to+","+graph.G.get(i).get(j).weight+" ");
			}
			System.out.println();
		}
	}

	public void newGraph(String identifier,int n)throws java.rmi.RemoteException
	{
		if(graph_identifier.containsKey(identifier) == true)
			System.out.println("Graph with same key already present");
		else
		{
			Graph g = new Graph(n);
			graph_identifier.put(identifier,g);

			// System.out.println(graph_identifier);

			System.out.println("Graph added");
		}

	}



	public void addEdge(String identifier,int from,int to,int weight)throws java.rmi.RemoteException
	{
		if(graph_identifier.containsKey(identifier) == false)
			System.out.println("No Graph with the given identifier present");
		else
		{
			// System.out.println("Hello");
			Graph g = graph_identifier.get(identifier);

			Edge e1 = new Edge(from,to,weight);
			Edge e2 = new Edge(to,from,weight);


			g.G.get(from).add(e1);
			g.G.get(to).add(e2);


			System.out.println("Added Edge");

			printGraph(g);
		}
		

		// System.out.println(e1.from+" "+e1.to+" "+e1.weight);
	}

	public int mstPrims(String identifier)throws java.rmi.RemoteException
	{

		ArrayList<Edge> mst = new ArrayList<>();

		if(graph_identifier.containsKey(identifier) == false)
		{
			return -1;  
		}
		else
		{
			Graph graph = graph_identifier.get(identifier);
		

			ArrayList<ArrayList<Edge>> G = graph.G;

			PriorityQueue<Edge> p = new PriorityQueue<>((Object o1,Object o2) ->{
					Edge e1 = (Edge)o1;
					Edge e2 = (Edge)o2;

					if(e1.weight < e2.weight)
						return -1;
					else if(e1.weight > e2.weight)
						return 1;
					else
						return 0;
			});


			if(G.isEmpty() == true)
				throw new NullPointerException("The Graph is empty");

			Boolean[] visited = new Boolean[graph.V+1];

			for(int i=0;i<(graph.V+1);i++)
				visited[i] = false;

			for(int i=0;i<G.get(1).size();i++)
			{
				p.add(G.get(1).get(i));
			}

			// System.out.println(p);

			visited[1] = true;

			while(p.isEmpty() == false)
			{
				Edge e = p.peek();
				// System.out.println(e.to);
				p.poll();

				if(visited[e.from] == true && visited[e.to] == true)
					continue;

				visited[e.from] = true;

				for(Edge edge:G.get(e.to))
				{
					if(visited[edge.to] == false)
					{
						p.add(edge);
					}
				}

				visited[e.to] = true;
				mst.add(e);
			}

			int ans = 0,l = mst.size();

			// System.out.println(l);



			if(l != (graph.V - 1))
				return -1;
			else
			{
				for(Edge e:mst)
				{
					ans += e.weight;
				}

				return ans;

			}

			
		}



	}

	// public static void main(String[] args)throws java.rmi.RemoteException
	// {
	// 	// Graph graph = new Graph(9);
	// 	GraphMst e = new GraphMst();
	// 	Graph graph = new Graph(9);

	// 	ArrayList<Edge> mst;

	// 	// System.out.println(e);

	// 	e.addEdge(graph, 0, 1, 4);
	// 	e.addEdge(graph, 0, 1, 2);
	// 	e.addEdge(graph, 0, 1, 1);
	// 	e.addEdge(graph, 1, 1, 10);
	// 	e.addEdge(graph, 3, 3, 1);
	// 	e.addEdge(graph, 0, 7, 8); 
	// 	e.addEdge(graph, 1, 2, 8); 
	// 	e.addEdge(graph, 1, 7, 11); 
	// 	e.addEdge(graph, 2, 3, 7); 
	// 	e.addEdge(graph, 2, 8, 2); 
	// 	e.addEdge(graph, 2, 5, 4); 
	// 	e.addEdge(graph, 2, 5, 10); 
	// 	e.addEdge(graph, 3, 4, 9); 
	// 	e.addEdge(graph, 3, 5, 14); 
	// 	e.addEdge(graph, 4, 5, 10); 
	// 	e.addEdge(graph, 5, 6, 2); 
	// 	e.addEdge(graph, 6, 7, 1); 
	// 	e.addEdge(graph, 6, 8, 6); 
	// 	e.addEdge(graph, 7, 8, 7);

	// 	// // System.out.println("Printing Graph");
	// 	// // e.printGraph(graph);

	// 	mst = e.mstPrims(graph);

	// 	System.out.println("MST: ");
	// 	for(Edge edge:mst)
	// 	{
	// 		System.out.println(edge.from+" "+edge.to+" "+edge.weight);
	// 	}
	// }
}