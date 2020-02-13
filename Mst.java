import java.util.*;

public interface Mst extends java.rmi.Remote
{
	int get_mst(String identifier)throws java.rmi.RemoteException;
	void add_edge(String identifier,int from,int to,int weight)throws java.rmi.RemoteException;
	void new_graph(String identifier,int n)throws java.rmi.RemoteException;
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

			for(int i=0;i<=vertices;i++)
			{
				G.add(new ArrayList<>());
			}
		}
	}
	
}


