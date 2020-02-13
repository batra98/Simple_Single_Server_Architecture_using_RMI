import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.NotBoundException; 
import java.rmi.RemoteException;
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*;

public class Client
{
	public static void main(String[] args)
	{
		try {

            if(args.length != 2)
            {
                System.out.println("Error: Specify ip and port in that order");
                System.exit(0);
            }

            String server_ip = args[0];
            Integer server_port = Integer.parseInt(args[1]);

            Mst c = (Mst)Naming.lookup("rmi://"+server_ip+":"+server_port+"/Mst");

            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));

            String inputLine = null, graph_name = null;
            Integer u,v,n,w;

            while(true)
            {
                try
                {
                    inputLine = bufferedreader.readLine();

                    if(inputLine == null)
                        break;

                    if(inputLine.length() == 0)
                        continue;

                    StringTokenizer tokens = new StringTokenizer(inputLine);

                    String comm = tokens.nextToken();

                    if(comm.equals("add_graph"))
                    {
                        if(tokens.countTokens() != 2)
                        {
                            System.out.println("Usage: add_graph <graph_identifier> n");
                            continue;
                        }

                        graph_name = tokens.nextToken();
                        n = Integer.parseInt(tokens.nextToken());

                        c.new_graph(graph_name,n);



                    }
                    else if(comm.equals("add_edge"))
                    {
                        if(tokens.countTokens() != 4)
                        {
                            System.out.println("Usage: add_edge <graph_identifier> <u> <v> <w>");
                            continue;
                        }

                        graph_name = tokens.nextToken();
                        u = Integer.parseInt(tokens.nextToken());
                        v = Integer.parseInt(tokens.nextToken());
                        w = Integer.parseInt(tokens.nextToken());
                        c.add_edge(graph_name,u,v,w);
                    }
                    else if(comm.equals("get_mst"))
                    {
                        if(tokens.countTokens() != 1)
                        {
                            System.out.println("Usage: get_mst <graph_identifier>");
                            continue;
                        }

                        graph_name = tokens.nextToken();

                        System.out.println(c.get_mst(graph_name));
                    }
                    else
                    {
                        System.out.println("Unrecognized command");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Err "+e);
                }
            }
  

            // c.new_graph("graph1",4); 
            // System.out.println(c.get_mst("graph1")); 
            // c.add_edge("graph1",1,2,10); 
            // c.add_edge("graph1",2,3,15); 
            // c.add_edge("graph1",1,3,5); 
            // c.add_edge("graph1",4,2,2); 
            // c.add_edge("graph1",4,3,40); 
            // System.out.println(c.get_mst("graph1")); 
        } 
  
        catch (MalformedURLException murle) { 
            System.out.println("\nMalformedURLException: "
                               + murle); 
        } 
  
        catch (RemoteException re) { 
            System.out.println("\nRemoteException: "
                               + re); 
        } 
  
        catch (NotBoundException nbe) { 
            System.out.println("\nNotBoundException: "
                               + nbe); 
        } 
  
        catch (java.lang.ArithmeticException ae) { 
            System.out.println("\nArithmeticException: " + ae); 
        }
	}
}