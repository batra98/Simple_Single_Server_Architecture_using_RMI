import java.util.*;

public interface Mst extends java.rmi.Remote
{
	ArrayList<Edge> mstPrims(Graph graph)throws java.rmi.RemoteException;
	void addEdge(Graph graph,int from,int to,int weight)throws java.rmi.RemoteException;
	// void printGraph(Graph graph)throws java.rmi.RemoteException;

	public class Edge
	{
		int from,to,weight;

		Edge(int f,int t,int w)
		{
			from = f;
			to = t;
			weight = w;
		}
	}

	public class Graph
	{
		int V;
		ArrayList<ArrayList<Edge>> G;

		Graph(int vertices)
		{
			V = vertices;
			G = new ArrayList<>();

			for(int i=0;i<vertices;i++)
			{
				G.add(new ArrayList<>());
			}
		}
	}
	
}


