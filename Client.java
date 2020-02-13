import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.NotBoundException; 
import java.rmi.RemoteException;

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
  

            c.newGraph("graph1",4); 
            System.out.println(c.mstPrims("graph1")); 
            c.addEdge("graph1",1,2,10); 
            c.addEdge("graph1",2,3,15); 
            c.addEdge("graph1",1,3,5); 
            c.addEdge("graph1",4,2,2); 
            c.addEdge("graph1",4,3,40); 
            System.out.println(c.mstPrims("graph1")); 
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